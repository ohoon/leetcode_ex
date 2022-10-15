/*
1685.
Sum of Absolute Differences in a Sorted Array
https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
*/

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] sum = nums.clone();
        for (int i = 1; i < n; i++) {       // sum 누적값
            sum[i] += sum[i-1];
        }
        
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (nums[i] * (i+1) - sum[i]) + (sum[n-1] - sum[i] - nums[i] * (n-i-1));       // {nums[0], nums[1], ..., nums[n-1]} -> {nums[i], nums[i], ..., nums[i]}
        }
        
        return answer;
    }
}

/*
Runtime: 20 ms, faster than 10.91% of Java online submissions for Sum of Absolute Differences in a Sorted Array.
Memory Usage: 120.7 MB, less than 24.19% of Java online submissions for Sum of Absolute Differences in a Sorted Array.
*/
