class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        var runningInterval = intervals[0];
        var removalCount = 0;
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= runningInterval[1]) {
                runningInterval = intervals[i];
            } else {
                runningInterval = runningInterval[1] < intervals[i][1] ? runningInterval : intervals[i];
                removalCount += 1;
            }
        }

        return removalCount;
    }
}
