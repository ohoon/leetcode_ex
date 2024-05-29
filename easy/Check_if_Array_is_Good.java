/*
2784.
Check if Array is Good
https://leetcode.com/problems/check-if-array-is-good/
*/

class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length-1] != nums.length-1) {
            return false;
        }

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != i+1) {
                return false;
            }
        }

        return true;
    }
}