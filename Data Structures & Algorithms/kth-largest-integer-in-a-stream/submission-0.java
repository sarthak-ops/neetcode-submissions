class KthLargest {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if(heap.size() > k){
            heap.poll();
        }
        return heap.peek();
    }
}
