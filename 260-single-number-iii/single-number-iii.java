class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int[] result = new int[2];
        for(int i = 0; i< nums.length -1; i++){
            if(nums[i] != nums[i+1]){
                result[index] = nums[i];
                index++;
            } else {
                i++;
            }
        }
        if(index == 1){
                result[index] = nums[nums.length -1];
            }
        return result;
    }
}