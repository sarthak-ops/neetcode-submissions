class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int[] cur = intervals[0];
        int n = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] nex = intervals[i];
            if(nex[0] < cur[1]){
                n++;
                if(nex[1] < cur[1]){
                    cur = nex;
                }
            }
            else{
                cur = nex;
            }
        }
        return n;
    }
}
