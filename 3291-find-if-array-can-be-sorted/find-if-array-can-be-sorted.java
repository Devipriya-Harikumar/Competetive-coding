class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i = 0; i<nums.length; i++) {
            for(int j=0; j<nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]) {
                    if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1])){
                        //swap
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    } else return false;
                }
            }
        }
        return true;
    }
}