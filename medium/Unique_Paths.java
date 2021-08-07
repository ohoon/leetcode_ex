/*
62.
Unique Paths
https://leetcode.com/problems/unique-paths/
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;         // 시작지점 1으로 초기화
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < m-1) {
                    grid[i+1][j] += grid[i][j];     // 다음번에 이동할 수 있는 인덱스에 자신의 값 누적
                }

                if (j < n-1) {
                    grid[i][j+1] += grid[i][j];
                }
            }
        }

        return grid[m-1][n-1];                      // 누적된 값 = 도착 가능한 모든 경우의 수
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
Memory Usage: 35.8 MB, less than 65.55% of Java online submissions for Unique Paths.
*/
