class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int n: stones){maxheap.offer(n);}
        while(maxheap.size() > 1){
            int x = maxheap.poll();
            int y = maxheap.poll();
            if(x==y){continue;}
            else{
                maxheap.offer(x-y);
            }
        }
        if(maxheap.size() == 1){return maxheap.poll();}
        return 0;
    }
}
