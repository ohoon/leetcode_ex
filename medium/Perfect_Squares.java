/*
279.
Perfect Squares
https://leetcode.com/problems/perfect-squares/
*/

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; i + j*j <= n; j++) {        // i에서 square인 각각의 정수들을 더한 인덱스를 탐색
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i] + 1);     // 기존의 개수 값과 현재 dp[i]에서 j를 더한 개수 값 중에 작은 값으로 갱신
            }
        }
        
        return dp[n];
    }
}

/*
Runtime: 26 ms, faster than 82.10% of Java online submissions for Perfect Squares.
Memory Usage: 38 MB, less than 75.69% of Java online submissions for Perfect Squares.
*/
