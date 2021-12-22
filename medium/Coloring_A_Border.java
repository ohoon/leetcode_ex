/*
1034.
Coloring A Border
https://leetcode.com/problems/coloring-a-border/
*/

class Solution {
    private boolean isBorder(int[][] grid, int row, int col) {      // 해당 셀이 connected component의 테두리 부분인지 알려주는 메서드
        return row == 0 || 
            row == grid.length - 1 || 
            col == 0 || 
            col == grid[0].length - 1 || 
            grid[row][col] != grid[row-1][col] ||
            grid[row][col] != grid[row+1][col] ||
            grid[row][col] != grid[row][col-1] ||
            grid[row][col] != grid[row][col+1];
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {     // BFS
        int m = grid.length, n = grid[0].length;
        boolean[][] isRecolored = new boolean[m][n];        // 재색칠해야할 셀을 기록하는 배열
        boolean[][] isVisited = new boolean[m][n];          // 이미 방문한 셀을 기록하는 배열
        Queue<int[]> q = new LinkedList<>();                // 선입선출, BFS용
        q.offer(new int[]{row, col});
        isVisited[row][col] = true;
        while (!q.isEmpty()) {
            int len = q.size();                 // 현재 큐에 들어있는 요소들만 poll해서 사용
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                isRecolored[r][c] = isBorder(grid, r, c);                   // 테두리 부분이라면 마지막에 재색칠할 것임
                if (r > 0 && grid[r][c] == grid[r-1][c] && !isVisited[r-1][c]) {        // 상하좌우 4방향으로 connect component를 찾아서 탐색
                    isVisited[r-1][c] = true;
                    q.offer(new int[]{r-1, c});
                }
                
                if (r < m-1 && grid[r][c] == grid[r+1][c] && !isVisited[r+1][c]) {
                    isVisited[r+1][c] = true;
                    q.offer(new int[]{r+1, c});
                }
                
                if (c > 0 && grid[r][c] == grid[r][c-1] && !isVisited[r][c-1]) {
                    isVisited[r][c-1] = true;
                    q.offer(new int[]{r, c-1});
                }
                
                if (c < n-1 && grid[r][c] == grid[r][c+1] && !isVisited[r][c+1]) {
                    isVisited[r][c+1] = true;
                    q.offer(new int[]{r, c+1});
                }
            }
        }
        
        for (int i = 0; i < m; i++) {           // isRecolored 배열을 참고하여 셀을 재색칠
            for (int j = 0; j < n; j++) {
                if (isRecolored[i][j]) {
                    grid[i][j] = color;
                }
            }
        }
        
        return grid;
    }
}

/*
Runtime: 1 ms, faster than 89.10% of Java online submissions for Coloring A Border.
Memory Usage: 39.8 MB, less than 80.69% of Java online submissions for Coloring A Border.
*/
