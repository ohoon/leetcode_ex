/*
518.
Coin Change II
https://leetcode.com/problems/coin-change-ii/
*/

class Solution {
    public int change(int amount, int[] coins) {        // dp
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i = 0; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i-coin];
                }                
            }
        }

        return dp[amount];
    }
}
