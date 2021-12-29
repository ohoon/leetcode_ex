/*
287.
Find the Duplicate Number
https://leetcode.com/problems/find-the-duplicate-number/
*/

class Solution {
    public int findDuplicate(int[] nums) {      // sort
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                return nums[i];
            }
        }
        
        return -1;
    }
}

/*
Runtime: 30 ms, faster than 17.63% of Java online submissions for Find the Duplicate Number.
Memory Usage: 56.8 MB, less than 53.37% of Java online submissions for Find the Duplicate Number.
*/
