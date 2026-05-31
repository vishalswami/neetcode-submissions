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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()) {
            return 0;
        }

        intervals.sort(Comparator.comparingInt(val -> val.start));
        var roomAvailability = new PriorityQueue<Integer>();
        roomAvailability.offer(intervals.getFirst().end);

        for(int i =1; i<intervals.size(); i++) {
            if(roomAvailability.peek() <= intervals.get(i).start) {
                roomAvailability.poll();
                
            }
            roomAvailability.offer(intervals.get(i).end);
        }
        return roomAvailability.size();
    }
}
