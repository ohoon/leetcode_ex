'''
1909.
Remove One Element to Make the Array Strictly Increasing
https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
'''

class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;
        int p = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] >= nums[i+1]) {
                count++;
                p = i;
            }
        }
        
        if (count > 1) {        // 1개 이상의 변곡점이 있는 경우 false 반환
            return false;
        }
        
        if (count == 1) {       // 1개의 변곡점이 있고, 해당 변곡점을 제거했을 때 increasing되면 true 반환
            if (p == 0 || p == nums.length - 2) {
                return true; 
            }
            
            if (nums[p+1] > nums[p-1] || nums[p+2] > nums[p]) {
                return true;
            }
            
            return false;       // 변곡점을 제거해도 increasing하지 않으면 false 반환
        }
        
        return true;        // 변곡점 없이 increasing하면 true 반환
    }
}

'''
Runtime: 1 ms, faster than 41.68% of Java online submissions for Remove One Element to Make the Array Strictly Increasing.
Memory Usage: 40.1 MB, less than 25.29% of Java online submissions for Remove One Element to Make the Array Strictly Increasing.
'''
