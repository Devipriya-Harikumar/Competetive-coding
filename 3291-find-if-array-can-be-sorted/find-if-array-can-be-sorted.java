class Solution {
    public boolean canSortArray(int[] nums) {
        int maxOfSegment = nums[0];
        int minOfSegment = nums[0];
        int numOfSetBits = Integer.bitCount(nums[0]);
        int maxOfPrevSegment = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (Integer.bitCount(nums[i]) == numOfSetBits) {
                maxOfSegment = Math.max(nums[i],maxOfSegment);
                minOfSegment = Math.min(nums[i],minOfSegment);
            } else {
                if (minOfSegment < maxOfPrevSegment) {
                    return false;
                } else {
                    maxOfPrevSegment = maxOfSegment;
                    // Start new segment
                    numOfSetBits = Integer.bitCount(nums[i]);
                    maxOfSegment = nums[i];
                    minOfSegment = nums[i];
                }
            }
        }
        if (minOfSegment < maxOfPrevSegment) {
            return false;
        }
        return true;
    }
}