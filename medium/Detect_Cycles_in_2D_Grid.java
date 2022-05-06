/*
1559.
Detect Cycles in 2D Grid
https://leetcode.com/problems/detect-cycles-in-2d-grid/
*/

class Solution {
    private boolean dfs(char[][] grid, int fromX, int fromY, int toX, int toY) {        // 깊이 우선 탐색
        if (toX < 0 || toX >= grid[0].length || toY < 0 || toY >= grid.length) {        // 인덱스 범위 초과 처리
            return false;
        }
        
        if (grid[fromY][fromX] == grid[toY][toX]) {     // 방문한 셀은 대문자 상태가 되는데, 방문한 셀끼리 이동했다는 것(현재 셀(대문자) == 이전 셀(대문자))은 cycle 상태임
            return true;
        }
        
        if (Character.toLowerCase(grid[fromY][fromX]) != Character.toLowerCase(grid[toY][toX])) {       // 같은 알파벳이 아니면 순회하지 않고 바로 종료
            return false;
        }
        
        grid[toY][toX] = Character.toUpperCase(grid[toY][toX]);         // 대문자로 변환하는 것으로 방문했다는 것을 표시함
        return (toX+1 != fromX && dfs(grid, toX, toY, toX+1, toY)) ||   // 이전 셀로 다시 돌아감을 방지하기 위해서 toX+1 != fromX 같은 부분을 더해줌
            (toX-1 != fromX && dfs(grid, toX, toY, toX-1, toY)) || 
            (toY+1 != fromY && dfs(grid, toX, toY, toX, toY+1)) || 
            (toY-1 != fromY && dfs(grid, toX, toY, toX, toY-1));
    }
    
    public boolean containsCycle(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (Character.isUpperCase(grid[i][j])) {        // 이미 방문한 셀은 탐색에 들어가지 않음
                    continue;
                }
                
                grid[i][j] = Character.toUpperCase(grid[i][j]);
                if (dfs(grid, j, i, j+1, i) ||          // 상하좌우 탐색
                    dfs(grid, j, i, j-1, i) ||
                    dfs(grid, j, i, j, i+1) ||
                    dfs(grid, j, i, j, i-1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

/*
Runtime: 66 ms, faster than 11.84% of Java online submissions for Detect Cycles in 2D Grid.
Memory Usage: 143.7 MB, less than 34.60% of Java online submissions for Detect Cycles in 2D Grid.
*/
