class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i=0;
        for(i=0; i<intervals.length&&intervals[i][1] < newInterval[0]; i++){
                result.add(intervals[i]);
        }

        while(i<intervals.length && newInterval[1]>=intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while(i<intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

    }
}