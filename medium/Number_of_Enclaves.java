/*
1020.
Number of Enclaves
https://leetcode.com/problems/number-of-enclaves/
*/

class Solution {
    private void dfs(int[][] grid, int r, int c) {      // 해당 셀의 값을 0으로 만들고 상하좌우 방향으로 순회되는 메서드
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }
        
        grid[r][c] = 0;
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        dfs(grid, r+1, c);
    }
    
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && i < m-1 && j > 0 && j < n-1) {     // 가장자리 셀만 dfs 메서드가 실행됨
                    continue;
                }
                
                dfs(grid, i, j);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {          // 가장자리와 연결되지 않은 셀의 개수를 셂
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 8 ms, faster than 84.36% of Java online submissions for Number of Enclaves.
Memory Usage: 54.8 MB, less than 90.15% of Java online submissions for Number of Enclaves.
*/
