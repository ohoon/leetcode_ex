/*
73.
Set Matrix Zeroes
https://leetcode.com/problems/set-matrix-zeroes/
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];            // 해당 행에 0인 요소가 있는지
        boolean[] cols = new boolean[matrix[0].length];         // 해당 열에 0인 요소가 있는지
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {                        // 0인 요소를 찾으면 각 행과 열에 0이 있음을 표시
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] || cols[j]) {                       // 0인 요소가 포함된 행과 열은 0으로 변경
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/*
Runtime: 1 ms, faster than 93.56% of Java online submissions for Set Matrix Zeroes.
Memory Usage: 40.7 MB, less than 50.30% of Java online submissions for Set Matrix Zeroes.
*/
