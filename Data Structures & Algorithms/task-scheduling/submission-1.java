class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> temp = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int v : map.values()){
            maxheap.offer(v);
        }
        int ops = 0;
        while(maxheap.size() != 0){
            int work = 0;
            for(int i = 0; i <= n; i++){
                if(maxheap.isEmpty()) break;
                int max = maxheap.poll();
                max--;
                temp.add(max);
                work++;
            }
            for(int x : temp){
                if(x > 0){
                    maxheap.offer(x);
                }
            }
            if (maxheap.isEmpty()) {
                ops += work;
            } else {
                ops += n + 1;
            }
            temp.clear();
        }
        return ops;
    }
}
