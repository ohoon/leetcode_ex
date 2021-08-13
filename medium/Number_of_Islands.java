/*
200.
Number of Islands
https://leetcode.com/problems/number-of-islands/
*/

class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisit = new boolean[m][n];        // 어떤 땅과 연결된 지점은 isVisit에 마킹되어있음
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || isVisit[i][j]) {       // 땅이 아니거나 어떤 땅과 연결된 지점이면 answer을 늘리지 않음
                    continue;
                }
                
                answer++;
                dfs(grid, isVisit, i, j);       // 현재 땅을 기점으로 이어진 땅들을 깊이 우선 탐색
            }
        }
        
        return answer;
    }
    
    private void dfs(char[][] grid, boolean[][] isVisit, int i, int j) {
        isVisit[i][j] = true;       // 현재 위치의 땅을 visit 상태로 마킹
        if (i > 0 && grid[i-1][j] == '1' && !isVisit[i-1][j]) {     // 각각 이어진 땅들에 대해서 순회
            dfs(grid, isVisit, i-1, j);
        }

        if (j > 0 && grid[i][j-1] == '1' && !isVisit[i][j-1]) {
            dfs(grid, isVisit, i, j-1);
        }

        if (i < grid.length - 1 && grid[i+1][j] == '1' && !isVisit[i+1][j]) {
            dfs(grid, isVisit, i+1, j);
        }

        if (j < grid[0].length - 1 && grid[i][j+1] == '1' && !isVisit[i][j+1]) {
            dfs(grid, isVisit, i, j+1);
        }
    }
}

/*
Runtime: 1 ms, faster than 99.95% of Java online submissions for Number of Islands.
Memory Usage: 41.6 MB, less than 27.46% of Java online submissions for Number of Islands.
*/
