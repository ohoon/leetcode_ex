/*
2395.
Find Subarrays With Equal Sum
https://leetcode.com/problems/find-subarrays-with-equal-sum/
*/

class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length-1; i++) {
            if (set.contains(nums[i] + nums[i+1])) {
                return true;
            }
            
            set.add(nums[i] + nums[i+1]);
        }
        
        return false;
    }
}

/*
Runtime: 3 ms, faster than 30.77% of Java online submissions for Find Subarrays With Equal Sum.
Memory Usage: 42.1 MB, less than 46.15% of Java online submissions for Find Subarrays With Equal Sum.
*/
