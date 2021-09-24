/*
1991.
Find the Middle Index in Array
https://leetcode.com/problems/find-the-middle-index-in-array/
*/

class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {       // 0~i까지의 합 누적
            dp[i] = dp[i-1] + nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;
            if (i > 0) {                    // left는 0 ~ (middleIndex - 1)의 누적합
                left = dp[i-1];
            }
            
            if (i < n-1) {                  // right는 (middleIndex + 1) ~ n의 누적합 = (0 ~ n의 누적합) - (0 ~ middleIndex의 누적합)
                right = dp[n-1] - dp[i];
            }
            
            if (left == right) {            // middleIndex 조건에 부합하면 해당 인덱스 반환
                return i;
            }
        }
        
        return -1;
    }
}

/*
Runtime: 1 ms, faster than 81.58% of Java online submissions for Find the Middle Index in Array.
Memory Usage: 38.4 MB, less than 79.43% of Java online submissions for Find the Middle Index in Array.
*/
