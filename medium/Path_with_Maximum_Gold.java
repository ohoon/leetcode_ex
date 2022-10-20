/*
1219.
Path with Maximum Gold
https://leetcode.com/problems/path-with-maximum-gold/
*/

class Solution {
    private int dfs(int[][] grid, int r, int c) {       // backtrack
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {     // 범위를 벗어나거나 gold가 0인 cell은 탐색 멈춤
            return 0;
        }
        
        int gold = grid[r][c];
        grid[r][c] = 0;
        int max = Math.max(
            Math.max(dfs(grid, r-1, c), dfs(grid, r+1, c)),         // 상하좌우 탐색
            Math.max(dfs(grid, r, c-1), dfs(grid, r, c+1))
        );
        grid[r][c] = gold;
        return max + gold;
    }
    
    public int getMaximumGold(int[][] grid) {
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
Runtime: 119 ms, faster than 62.57% of Java online submissions for Path with Maximum Gold.
Memory Usage: 41.7 MB, less than 59.55% of Java online submissions for Path with Maximum Gold.
*/
