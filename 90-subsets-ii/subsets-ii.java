class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums);
        return result;
    }

    private void backtrack(int index, int[] nums){
        if(index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        backtrack(index +1, nums);

        while(index +1 <nums.length && nums[index] == nums[index+1]){
            index += 1;
        }
        subset.remove(subset.size() - 1);
        backtrack(index+1, nums);
    }
}