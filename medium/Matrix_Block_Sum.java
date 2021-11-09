/*
1314.
Matrix Block Sum
https://leetcode.com/problems/matrix-block-sum/
*/

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {           // 열방향으로 mat의 값들을 누적시킴
            for (int j = 1; j < n; j++) {
                mat[i][j] += mat[i][j-1];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = Math.max(i-k, 0); l <= Math.min(i+k, m-1); l++) {      // row에선 Math.max, min으로 반복 처리하고 col에선 누적시킨 값을 이용해 한번에 계산
                    answer[i][j] += mat[l][Math.min(j+k, n-1)] - ((j-k > 0) ? mat[l][j-k-1] : 0);
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 10 ms, faster than 28.69% of Java online submissions for Matrix Block Sum.
Memory Usage: 40.3 MB, less than 69.78% of Java online submissions for Matrix Block Sum.
*/
