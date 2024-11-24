class Solution {
    public int longestConsecutive(int[] nums) {
        //To avoid dupicates
        Set<Integer> hs = new HashSet<>();
        for(int n: nums) {
            hs.add(n);
        }
        int longest = 0;
        for(int i = 0; i<nums.length; i++) {
            if(hs.contains(nums[i] -1)) {
                continue;
            }
            int length = 0;
            while(hs.contains(nums[i] + length)){
                length++;
            }
            longest = Math.max(length, longest);
        }
        return longest;
    }
}