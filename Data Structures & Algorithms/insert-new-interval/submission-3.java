class Solution {

    private record Interval(int start, int end){}
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var newIntervalsList = new ArrayList<Interval>();

        for(int i=0; i<intervals.length; i++) {
            var currentInterval = intervals[i];
            if(newInterval[0] > currentInterval[1]) {
                newIntervalsList.add(new Interval(currentInterval[0], currentInterval[1]));
                continue;
            }
            if(newInterval[1]<currentInterval[0]) {
                newIntervalsList.add(new Interval(newInterval[0], newInterval[1]));
                // newIntervalList.add(new Interval(currentInterval[0], currentInterval[1]));
                addRemainingToList(i, newIntervalsList, intervals);
                return asArray(newIntervalsList);
            } else if((newInterval[0] >= currentInterval[0] && newInterval[0] <= currentInterval[1]) ||
             (newInterval[1] >= currentInterval[0] && newInterval[1] <= currentInterval[1])) {
                newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
            } else {
                //continue
            }
        }
        newIntervalsList.add(new Interval(newInterval[0], newInterval[1]));
        return asArray(newIntervalsList);
    }

    private int[][] asArray(List<Interval> list) {
        var array = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            array[i][0] = list.get(i).start();
            array[i][1] = list.get(i).end();
        }
        return array;
    }

    private void addRemainingToList(int intervalIndexToStart,List<Interval> newIntervalList,int[][] intervals){
        for(int i=intervalIndexToStart; i<intervals.length; i++) {
            newIntervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
    }
}
