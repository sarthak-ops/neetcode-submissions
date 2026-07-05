/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> x = new HashMap<>();
        Node dummy = new Node(0);
        Node second = dummy;
        Node curr = head;
        while(curr != null){
            Node n = new Node(curr.val);
            second.next = n;
            x.put(curr, n);
            second = second.next;
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy = x.get(curr);
            copy.random = x.get(curr.random);
            curr = curr.next;
        }

        return dummy.next;
    }
}
