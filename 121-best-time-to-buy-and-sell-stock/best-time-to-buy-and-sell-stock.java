class Solution {
    public int maxProfit(int[] prices) {
        int leftIndex = 0;
        int rightIndex = 1;
        int max = 0;
        for(; rightIndex< prices.length; rightIndex++) {
            if(prices[leftIndex] < prices[rightIndex] ) {
                max = Math.max(max, prices[rightIndex] - prices[leftIndex]);
            } else {
                leftIndex = rightIndex;
            }  
        }
        return max;
    }
}