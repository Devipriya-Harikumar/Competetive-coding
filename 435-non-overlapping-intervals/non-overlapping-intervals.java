class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(o -> o[0]));
        int result = 0;
        int prevEnd = intervals[0][1];
         for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= prevEnd){
                prevEnd = intervals[i][1];
            } else {
                result++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            }
        }
        return result;
    }
}