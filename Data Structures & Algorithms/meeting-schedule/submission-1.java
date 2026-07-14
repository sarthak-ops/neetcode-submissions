/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        intervals.sort((a, b) -> a.start-b.start);
        boolean x = true;
        Interval cur = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval nex = intervals.get(i);
            if(nex.start < cur.end){
                x = false;
            }
            else{
                cur = nex;
            }
        }
        return x;
    }
}
