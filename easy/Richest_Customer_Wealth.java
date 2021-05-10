/*
1672.
Richest Customer Wealth
https://leetcode.com/problems/richest-customer-wealth/
*/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int answer = 0;
        for (int[] acc : accounts) {
            int sum = 0;            // 각 customer의 재산 합
            for (int w : acc) {
                sum += w;
            }
            
            answer = Math.max(answer, sum);     // 최대 재산 갱신
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Richest Customer Wealth.
Memory Usage: 38.4 MB, less than 82.73% of Java online submissions for Richest Customer Wealth.
*/
