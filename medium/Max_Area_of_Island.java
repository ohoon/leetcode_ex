/*
695.
Max Area of Island
https://leetcode.com/problems/max-area-of-island/
*/

class Solution {
    private int dfs(int[][] grid, int r, int c) {       // 깊이 우선 탐색
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        
        grid[r][c] = 0;         // 재참조를 방지하기 위해 탐색한 셀은 0으로 만듬
        return 1 + dfs(grid, r-1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1) + dfs(grid, r+1, c);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                answer = Math.max(answer, dfs(grid, i, j));
            }
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 44.83% of Java online submissions for Max Area of Island.
Memory Usage: 46.3 MB, less than 72.93% of Java online submissions for Max Area of Island.
*/
