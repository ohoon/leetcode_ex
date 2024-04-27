/*
2706.
Buy Two Chocolates
https://leetcode.com/problems/buy-two-chocolates/
*/

class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int cost = prices[0] + prices[1];
        return cost > money ? money : money - cost;
    }
}
