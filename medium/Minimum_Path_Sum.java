/*
64.
Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/
*/

class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {            // 오른쪽 밑인 도착지점부터 dynamic programming 기법으로 풀이
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i < grid.length - 1 && j < grid[0].length - 1) {            // 아래 또는 오른쪽으로 이동 가능한 지점이면 더 cost가 작은 쪽으로 계산하여 누적
                    grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
                } else if (i < grid.length - 1) {                               // 아래쪽으로만 이동 가능한 지점이면 아래쪽의 cost을 누적
                    grid[i][j] += grid[i+1][j];
                } else if (j < grid[0].length - 1) {                            // 오른쪽으로만 이동 가능한 지점이면 오른쪽의 cost를 누적
                    grid[i][j] += grid[i][j+1];
                }
            }
        }
        return grid[0][0];                                                      // 최종적으로 누적된 값을 반환
    }
}

/*
Runtime: 3 ms, faster than 30.59% of Java online submissions for Minimum Path Sum.
Memory Usage: 41.9 MB, less than 43.32% of Java online submissions for Minimum Path Sum.
*/
