class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int st = 0;
        int end = nums.length -1;
        int result = nums[0];
         while (st < end) {
            int mid = st + (end - st) / 2;

            // Compare mid with end to determine the direction
            if (nums[mid] < nums[end]) {
                end = mid; // Minimum is in the left half
            } else if (nums[mid] > nums[end]) {
                st = mid + 1; // Minimum is in the right half
            } else {
                // arr[mid] == arr[end], we cannot decide the direction, reduce end
                end--;
            }
        }

        return nums[st];
    }
}