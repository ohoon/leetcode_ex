/*
1827.
Minimum Operations to Make the Array Increasing
https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
*/

class Solution {
    public int minOperations(int[] nums) {
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] >= nums[i]) {
                answer += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
            }
        }

        return answer;
    }
}

/*
Runtime: 4 ms, faster than 22.38% of Java online submissions for Minimum Operations to Make the Array Increasing.
Memory Usage: 46.2 MB, less than 10.78% of Java online submissions for Minimum Operations to Make the Array Increasing.
*/
