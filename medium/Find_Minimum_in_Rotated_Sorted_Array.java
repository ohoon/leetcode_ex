/*
153.
Find Minimum in Rotated Sorted Array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*/

class Solution {
    public int findMin(int[] nums) {
        int L = 0, R = nums.length - 1;
        while (L + 1 < R) {                 // nums[L], nums[mid], nums[R] 값을 비교해서 범위를 좁혀나감
            int mid = (L + R) / 2;
            if (nums[L] < nums[mid] && nums[L] < nums[R]) {
                return nums[L];
            }
            
            if (nums[mid] < nums[L] && nums[mid] < nums[R]) {
                R = mid;
            } else {
                L = mid;
            }
        }
        
        return Math.min(nums[L], nums[R]);
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
Memory Usage: 43 MB, less than 18.55% of Java online submissions for Find Minimum in Rotated Sorted Array.
*/
