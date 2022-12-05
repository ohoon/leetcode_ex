/*
2110.
Number of Smooth Descent Periods of a Stock
https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/
*/

class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length, prev = 0;
        long answer = n;
        for (int i = 0; i < n-1; i++) {
            if (prices[i] - prices[i+1] == 1) {
                answer += ++prev;       // 1씩 감소되는 것이 연속될수록 answer에 더해지는 값이 커짐
                continue;
            }

            prev = 0;
        }

        return answer;
    }
}
