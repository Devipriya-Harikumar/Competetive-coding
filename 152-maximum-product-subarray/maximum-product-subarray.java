class Solution {
    public int maxProduct(int[] nums) {
        double max_end_here = (double)nums[0];
        double min_end_here = (double)nums[0];
        double max_so_far = (double)nums[0];
        for(int i = 1; i< nums.length; i++) {
            double temp = (double)Math.max(Math.max(max_end_here * nums[i], nums[i]), min_end_here * nums[i]);
            min_end_here = (double)Math.min(Math.min(max_end_here * nums[i], nums[i]), min_end_here * nums[i]);
            max_end_here = temp;
            if(max_so_far< max_end_here){
                max_so_far = max_end_here;
            }
        }
        return (int)max_so_far;
    }
}