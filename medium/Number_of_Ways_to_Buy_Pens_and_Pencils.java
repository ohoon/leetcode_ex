/*
2240.
Number of Ways to Buy Pens and Pencils
https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/
*/

class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long answer = 0;
        while (total >= 0) {
            answer += total / cost2 + 1;
            total -= cost1;
        }
        
        return answer;
    }
}
