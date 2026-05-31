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
        if(intervals.isEmpty()){
            return true;
        }
        intervals.sort(Comparator.comparingInt(value -> value.start));

        Interval runningInterval = null;
        for(Interval interval: intervals) {
            if(runningInterval == null) {
                runningInterval = interval;
                continue;
            }
            if(runningInterval.end <= interval.start) {
                runningInterval = interval;
            } else {
                return false;
            }
        }
        return true;
    }
}
