/*
2760.
Longest Even Odd Subarray With Threshold
https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
*/

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int answer = 0, len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold || nums[i] % 2 != len % 2) {
                answer = Math.max(answer, len);
                len = nums[i] <= threshold && nums[i] % 2 == 0 ? 1 : 0;
                continue;
            }

            len++;
        }

        return Math.max(answer, len);
    }
}
