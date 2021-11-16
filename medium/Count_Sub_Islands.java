/*
1905.
Count Sub Islands
https://leetcode.com/problems/count-sub-islands/
*/

class Solution {
    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {       // 깊이 우선 탐색
        if (r < 0 || r >= grid2.length || c < 0 || c >= grid2[0].length || grid2[r][c] == 0) {
            return true;
        }
        
        grid2[r][c] = 0;        // 방문한 땅은 0으로 변경
        boolean t1 = dfs(grid1, grid2, r-1, c);     // 상하좌우 방향으로 깊이 우선 탐색
        boolean t2 = dfs(grid1, grid2, r+1, c);
        boolean t3 = dfs(grid1, grid2, r, c-1);
        boolean t4 = dfs(grid1, grid2, r, c+1);
        return t1 && t2 && t3 && t4 && grid1[r][c] == 1;        // 각 방향별로 결과 중에 false가 있거나 현재 땅이 grid1에선 물일 경우 false 반환
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int answer = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 0) {
                    continue;
                }
                
                if (dfs(grid1, grid2, i, j)) {      // 깊이우선탐색 결과가 true면 answer 증가
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 19 ms, faster than 74.07% of Java online submissions for Count Sub Islands.
Memory Usage: 84.4 MB, less than 55.83% of Java online submissions for Count Sub Islands.
*/
