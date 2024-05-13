/*
2733.
Neither Minimum nor Maximum
https://leetcode.com/problems/neither-minimum-nor-maximum/
*/

class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }

        return ((nums[1] - nums[0]) * (nums[2] - nums[0]) < 0 ?
         nums[0] : 
         ((nums[0] - nums[1]) * (nums[2] - nums[1]) < 0 ?
          nums[1] : 
          nums[2]));
    }
}
