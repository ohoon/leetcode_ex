/*
2104.
Sum of Subarray Ranges
https://leetcode.com/problems/sum-of-subarray-ranges/
*/

class Solution {
    public long subArrayRanges(int[] nums) {
        long answer = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                answer += max - min;
            }
        }

        return answer;
    }
}
