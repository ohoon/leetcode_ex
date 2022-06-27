/*
2319.
Check if Matrix Is X-Matrix
https://leetcode.com/problems/check-if-matrix-is-x-matrix/
*/

class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j + 1 == n) {     // 대각선에 해당하면
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {                            // 대각선이 아닌 나머지 
                    if (grid[i][j] > 0) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}

/*
Runtime: 2 ms, faster than 87.50% of Java online submissions for Check if Matrix Is X-Matrix.
Memory Usage: 54.6 MB, less than 12.50% of Java online submissions for Check if Matrix Is X-Matrix.
*/
