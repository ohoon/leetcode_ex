/*
2221.
Find Triangular Sum of an Array
https://leetcode.com/problems/find-triangular-sum-of-an-array/
*/

class Solution {
    public int triangularSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] next = new int[nums.length-1];        // nums의 sum들이 담겨질 배열
        for (int i = 0; i < nums.length - 1; i++) { // sum 값을 next에 넣는 작업
            next[i] = (nums[i] + nums[i+1]) % 10;
        }
        
        return triangularSum(next);     // next를 넘겨주며 순회
    }
}

/*
Runtime: 93 ms, faster than 68.78% of Java online submissions for Find Triangular Sum of an Array.
Memory Usage: 42.5 MB, less than 87.09% of Java online submissions for Find Triangular Sum of an Array.
*/
