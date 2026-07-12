class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = 0;
        int nomax = 0;
        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                nomax = 1;
            }
            else if(map.get(key) == max){
                nomax++;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + nomax);
    }
}
