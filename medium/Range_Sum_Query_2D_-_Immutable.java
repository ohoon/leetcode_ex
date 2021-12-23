/*
304.
Range Sum Query 2D - Immutable
https://leetcode.com/problems/range-sum-query-2d-immutable/
*/

class NumMatrix {

    private int[][] M;
    
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        M = new int[m][n];
        for (int i = 0; i < m; i++) {           // 각 행별로 matrix값을 누적시켜서 삽입
            M[i][0] = matrix[i][0];
            for (int j = 1; j < n; j++) {
                M[i][j] += matrix[i][j] + M[i][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {    // 각 행별로 0~col2까지의 합에서 0~col1 전까지의 합을 빼는 것으로 col1~col2의 합을 구함
            sum += M[i][col2];
            if (col1 > 0) {     // col1이 첫번째 열이면 0~col2의 값만 구하면 됨
                sum -= M[i][col1-1];
            }
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

/*
Runtime: 128 ms, faster than 36.77% of Java online submissions for Range Sum Query 2D - Immutable.
Memory Usage: 66.6 MB, less than 63.65% of Java online submissions for Range Sum Query 2D - Immutable.
*/
