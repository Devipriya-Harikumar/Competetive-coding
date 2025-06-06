class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount +1];
        Arrays.setAll(dp, i -> amount +1);
        dp[0] = 0;

        for(int i = 1; i<=amount; i++){
            for(int coin : coins){
                if(i-coin >= 0){
                    dp[i] = Math.min(dp[i], 1+ dp[i-coin]);
                }
            }
        }
        if(dp[amount] == amount+1) return -1;
        return dp[amount];
    }
}