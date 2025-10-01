class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[1]));
        long lastIndex = Long.MIN_VALUE;
        int minIntervals = 0;
        for(int[]interval : intervals) {
            if(interval[0]<lastIndex) {
                minIntervals++;
            } else {
                lastIndex = interval[1];
            }
        }
        return minIntervals;
    }
}
