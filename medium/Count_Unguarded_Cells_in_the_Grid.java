/*
2257.
Count Unguarded Cells in the Grid
https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
*/

class Solution {
    private void protect(int i, int j, int[] dir, int[][] grid) {
        while (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] < 1) {
            grid[i][j] = -1;
            i += dir[0];
            j += dir[1];
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                for (int[] dir : dirs) {
                    protect(i+dir[0], j+dir[1], dir, grid);
                }
            }
        }

        int answer = 0;
        for (int[] row : grid) {
            for (int col : row) {
                if (col == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
