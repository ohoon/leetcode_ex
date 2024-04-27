/*
2717.
Semi-Ordered Permutation
https://leetcode.com/problems/semi-ordered-permutation/
*/

class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return minIndex < maxIndex ? minIndex + nums.length - maxIndex - 1 : minIndex + nums.length - maxIndex - 2;
    }
}
