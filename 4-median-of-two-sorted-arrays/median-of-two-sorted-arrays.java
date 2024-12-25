class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] mergedArray = new int[len1 + len2];

        int i = 0, j = 0, index = 0;

        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                mergedArray[index] = nums1[i];
                i++;
                index++;
            } else {
                mergedArray[index] = nums2[j];
                j++;
                index++;
            }
        }
        while (i < len1) {
            mergedArray[index] = nums1[i];
            i++;
            index++;
        }
        while (j < len2) {
            mergedArray[index] = nums2[j];
            j++;
            index++;
        }
        System.out.print(Arrays.toString(mergedArray));
        index = len1 + len2;
        if((index)%2 == 0){
            return ((double)mergedArray[index/2] + (double)mergedArray[index/2 - 1])/2;
        } else {
            return mergedArray[index/2];
        }
    }
}