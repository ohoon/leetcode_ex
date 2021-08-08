/*
63.
Unique Paths II
https://leetcode.com/problems/unique-paths-ii/
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        if (obstacleGrid[0][0] == 0) {
            grid[0][0] = 1;         // 시작지점을 1로 초기화
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {      // 방해물이 있으면 해당 인덱스의 요소 값은 0
                    continue;
                }
                
                if (i > 0) {                        // 현재 요소 위의 값과 왼쪽 요소의 값을 누적
                    grid[i][j] += grid[i-1][j];
                }
                
                if (j > 0) {
                    grid[i][j] += grid[i][j-1];
                }
            }
        }
        
        return grid[m-1][n-1];
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
Memory Usage: 38.7 MB, less than 14.83% of Java online submissions for Unique Paths II.
*/
