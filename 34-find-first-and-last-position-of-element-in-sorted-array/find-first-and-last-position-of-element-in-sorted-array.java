class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[] { -1, -1 };

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int i = mid;
                while (i >= 0 && nums[i] == target) {
                    --i;
                }
                result[0] = i + 1;
                i = mid;
                while (i <= (nums.length - 1) && nums[i] == target) {
                    ++i;
                }
                result[1] = i - 1;
                left = right+1;
            }
        }
        return result;
    }
}