class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            if(valueIndexMap.containsKey(target - nums[i])) {
                return new int[]{i, valueIndexMap.get(target-nums[i])};
            } else {
                valueIndexMap.put(nums[i], i);
            }
        } 
        return new int[]{};
    }
}