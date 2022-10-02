/*
2427.
Number of Common Factors
https://leetcode.com/problems/number-of-common-factors/
*/

class Solution {
    public int commonFactors(int a, int b) {
        int answer = 0;
        for (int i = 1; i <= Math.min(a,b); i++) {
            if (a % i == 0 && b % i == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 25.00% of Java online submissions for Number of Common Factors.
Memory Usage: 41.2 MB, less than 50.00% of Java online submissions for Number of Common Factors.
*/
