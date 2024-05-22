/*
2765.
Longest Alternating Subarray
https://leetcode.com/problems/longest-alternating-subarray/
*/

class Solution {
    public int alternatingSubarray(int[] nums) {
        int answer = -1;
        int L = 0, R = 2;
        while (R < nums.length) {
            if (nums[L+1] - nums[L] != 1) {
                L = R++-1;
                continue;
            }

            if (nums[R] != nums[L+(R-L)%2]) {
                L = R-1;
            }

            answer = Math.max(answer, ++R-L);
        }

        if (nums[L+1] - nums[L] == 1) {
            answer = Math.max(answer, 2);
        }

        return answer;
    }
}