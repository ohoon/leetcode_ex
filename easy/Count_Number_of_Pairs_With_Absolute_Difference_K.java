/*
2006.
Count Number of Pairs With Absolute Difference K
https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
*/

class Solution {
    public int countKDifference(int[] nums, int k) {
        int answer = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {     // nums[i]와 nums[j]의 차이가 k면 answer 증가
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 6 ms, faster than 75.60% of Java online submissions for Count Number of Pairs With Absolute Difference K.
Memory Usage: 38.6 MB, less than 68.33% of Java online submissions for Count Number of Pairs With Absolute Difference K.
*/
