class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> x = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] nex = intervals[i];
            if(nex[0] <= cur[1]){
                cur[1] = Math.max(nex[1], cur[1]);
            }
            else{
                x.add(cur);
                cur = nex;
            }
        }
        x.add(cur);
        return x.toArray(new int[x.size()][]);
    }
}
