/*
2778.
Sum of Squares of Special Elements
https://leetcode.com/problems/sum-of-squares-of-special-elements/
*/

class Solution {
    public int sumOfSquares(int[] nums) {
        int answer = 0;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (n%i != 0) {
                continue;
            }

            answer += nums[i-1] * nums[i-1];
        }

        return answer;
    }
}