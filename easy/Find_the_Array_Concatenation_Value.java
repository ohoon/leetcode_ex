/*
2562.
Find the Array Concatenation Value
https://leetcode.com/problems/find-the-array-concatenation-value/
*/

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long answer = 0;
        int n = nums.length;
        for (int i = 0; i < n/2; i++) {
            answer += Long.valueOf(String.valueOf(nums[i]) + String.valueOf(nums[n-i-1]));
        }

        if (n % 2 == 1) {
            answer += nums[n/2];
        }

        return answer;
    }
}
