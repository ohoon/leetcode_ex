/*
2460.
Apply Operations to an Array
https://leetcode.com/problems/apply-operations-to-an-array/
*/

class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0) {
                continue;
            }

            if (nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }

        int[] answer = new int[nums.length];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            answer[cur++] = nums[i];
        }

        return answer;
    }
}
