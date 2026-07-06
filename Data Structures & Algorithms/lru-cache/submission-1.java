class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int max_capacity;
    private final HashMap<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.max_capacity = capacity;
        this.cache = new HashMap<>();
        
        // Dummy boundary nodes
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Update value
            moveToHead(node);
        } else {
            // Evict if we hit capacity limit *before* adding the new node
            if (cache.size() >= max_capacity) {
                Node lru = tail.prev; 
                removeNode(lru);       // Remove from list
                cache.remove(lru.key); // Remove from map
            }
            
            Node created = new Node(key, value);
            addNode(created);          // Add to front of list
            cache.put(key, created);   // Add to map
        }
    }

    // --- Private Linked List Helper Methods ---

    // Always inserts a node directly right after the dummy head
    private void addNode(Node node) {
        Node first = head.next;
        
        head.next = node;
        node.prev = head;
        
        node.next = first;
        first.prev = node;
    }

    // Unlinks an existing node from its current spot in the list
    private void removeNode(Node node) {
        Node bef = node.prev;
        Node aft = node.next;
        
        bef.next = aft;
        aft.prev = bef;
    }

    // Moves an existing node to the MRU (Most Recently Used) position
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
}