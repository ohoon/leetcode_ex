/*
1091.
Shortest Path in Binary Matrix
https://leetcode.com/problems/shortest-path-in-binary-matrix/
*/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {     // bfs
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                if (curPos[0] == row - 1 && curPos[1] == col - 1) {
                    return ans;
                }

                for (int[] dir : dirs) {
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];
                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY] || grid[nextX][nextY] == 1) {
                        continue;
                    }

                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }
}

/*
Runtime: 27 ms, faster than 50.30% of Java online submissions for Shortest Path in Binary Matrix.
Memory Usage: 59.2 MB, less than 62.12% of Java online submissions for Shortest Path in Binary Matrix.
*/

/*
나의 풀이

class Solution {
    private int dfs(int[][] grid, int[][] memo, int r, int c) {     // dfs
        if (r < 0 || r == grid.length || c < 0 || c == grid.length || grid[r][c] == 1) {
            return Integer.MAX_VALUE;
        }
        
        if (r == grid.length - 1 && c == grid.length - 1) {
            return 1;
        }
        
        if (memo[r][c] > 0) {
            return memo[r][c];
        }
        
        grid[r][c] = 1;
        int result = Math.min(dfs(grid, memo, r+1, c), dfs(grid, memo, r-1, c));
        result = Math.min(result, dfs(grid, memo, r, c+1));
        result = Math.min(result, dfs(grid, memo, r, c-1));
        result = Math.min(result, dfs(grid, memo, r-1, c-1));
        result = Math.min(result, dfs(grid, memo, r-1, c+1));
        result = Math.min(result, dfs(grid, memo, r+1, c-1));
        result = Math.min(result, dfs(grid, memo, r+1, c+1));
        grid[r][c] = 0;
        memo[r][c] = (result == Integer.MAX_VALUE ? result : result + 1);
        return memo[r][c];
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int answer = dfs(grid, new int[grid.length][grid.length], 0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}

최단 경로 문제인걸 생각 못하고 깊이 우선 탐색 방법으로 풀다가 막혔음
코드를 보면 알다시피 순회도 많이하고 이해하기도 어려운거 같다..

*/
