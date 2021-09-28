/*
1984.
Minimum Difference Between Highest and Lowest of K Scores
https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
*/

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);      // 오름차순 정렬
        
        int answer = nums[nums.length-1];
        for (int i = k-1; i < nums.length; i++) {       // k 간격으로 sliding window
            answer = Math.min(answer, nums[i] - nums[i-k+1]);   // 오름차순으로 정렬되어 있기 때문에 각 window의 처음과 끝만 비교하면 됨
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 100.00% of Java online submissions for Minimum Difference Between Highest and Lowest of K Scores.
Memory Usage: 38.9 MB, less than 95.37% of Java online submissions for Minimum Difference Between Highest and Lowest of K Scores.
*/
