class Solution {
       List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        createSubset(nums,0);
        return result;
    }

    private void createSubset(int[] nums, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        createSubset(nums, index + 1);

        subset.remove(subset.size() - 1);
        createSubset(nums, index + 1);
    }
}