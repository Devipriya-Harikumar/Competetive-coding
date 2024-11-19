class Solution {
    public int longestConsecutive(int[] nums) {
            if(nums.length == 0) return 0;
        List<Integer> count = new ArrayList<>();
        int sequence = 1;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == (nums[i-1])) continue;
            if(nums[i] == (nums[i-1]+1)){
                sequence++;
            }
            else{
                count.add(sequence);
                sequence = 1;
            }
        }
        count.add(sequence);
        return count.stream().max((a, b) -> (a-b)).get();   
    }
}