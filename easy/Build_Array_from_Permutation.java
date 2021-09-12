'''
1920.
Build Array from Permutation
https://leetcode.com/problems/build-array-from-permutation/
'''

class Solution {
    public int[] buildArray(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[nums[i]];
        }
        
        return answer;
    }
}

'''
Runtime: 1 ms, faster than 99.97% of Java online submissions for Build Array from Permutation.
Memory Usage: 51.6 MB, less than 8.55% of Java online submissions for Build Array from Permutation.
'''
