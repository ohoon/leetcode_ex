/*
931.
Minimum Falling Path Sum
https://leetcode.com/problems/minimum-falling-path-sum/
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {          // dp
        int n = matrix.length;
        int[][] pathSum = new int[n][n];
        for (int j = 0; j < n; j++) {           // 첫 행만 matrix의 원소값을 넣고 나머지 행은 MAX_VALUE값을 넣어둠
            pathSum[0][j] = matrix[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pathSum[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    pathSum[i+1][j-1] = Math.min(pathSum[i+1][j-1], pathSum[i][j] + matrix[i+1][j-1]);      // 왼쪽 전파
                }
                
                pathSum[i+1][j] = Math.min(pathSum[i+1][j], pathSum[i][j] + matrix[i+1][j]);        // 가운데 전파
                if (j < n-1) {
                    pathSum[i+1][j+1] = Math.min(pathSum[i+1][j+1], pathSum[i][j] + matrix[i+1][j+1]);      // 오른쪽 전파
                }
            }
        }
        
        int answer = pathSum[n-1][0];
        for (int j = 1; j < n; j++) {       // 누적 결과가 있는 마지막 행만 비교
            answer = Math.min(answer, pathSum[n-1][j]);
        }
        
        return answer;
    }
}

/*
Runtime: 24 ms, faster than 14.23% of Java online submissions for Minimum Falling Path Sum.
Memory Usage: 47.4 MB, less than 64.98% of Java online submissions for Minimum Falling Path Sum.
*/
