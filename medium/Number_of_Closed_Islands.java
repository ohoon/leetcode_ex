/*
1254.
Number of Closed Islands
https://leetcode.com/problems/number-of-closed-islands/
*/

class Solution {
    private void dfs(int[][] grid, int r, int c) {      // 상하좌우 순회하며 값이 0인 셀을 1로 바꾸는 메서드
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 1) {
            return;
        }
        
        grid[r][c] = 1;
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        dfs(grid, r+1, c);
    }
    
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {               // 가장자리 부분에 있는 land를 water로 변환
            for (int j = 0; j < n; j++) {
                if (i > 0 && i < m-1 && j > 0 && j < n-1) {
                    continue;
                }
                
                if (grid[i][j] == 1) {
                    continue;
                }
                
                dfs(grid, i, j);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {       // 가운데 남아있는 land들의 개수를 셂
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                
                answer++;
                dfs(grid, i, j);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 80.53% of Java online submissions for Number of Closed Islands.
Memory Usage: 46.3 MB, less than 79.01% of Java online submissions for Number of Closed Islands.
*/
