class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] cur = intervals[0];
        int i = 1;
        while(i < intervals.length){
            if(cur[1] >= intervals[i][0]){
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
            else{
                ans.add(cur);
                cur = intervals[i];
            }
            i++;
        }
        ans.add(cur);
        return ans.toArray(new int[ans.size()][]);
    }
}
