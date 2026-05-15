class Solution {
    PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for(int num : stones){
            maxHeap.offer(num);
        }
        while(maxHeap.size() > 1){
            int i = maxHeap.poll();
            int j = maxHeap.poll();
            if(i == j){
                continue;
            }
            else if(i < j){
                int m = j-i;
                maxHeap.offer(m);
            }
            else{
                int m = i-j;
                maxHeap.offer(m);
            }
        }
        if(maxHeap.size() > 0){
            return maxHeap.peek();
        }
        else{
            return 0;
        }
    }
}
