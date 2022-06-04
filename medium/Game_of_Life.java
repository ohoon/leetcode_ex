/*
289.
Game of Life
https://leetcode.com/problems/game-of-life/
*/

class Solution {
    private int countNeighbors(int[][] board, int r, int c) {       // 주변에 살아있는 세포 개수를 측정하는 메서드
        int result = 0;
        if (r > 0) {
            if (c > 0) {
                result += board[r-1][c-1];
            }
            
            if (c < board[0].length-1) {
                result += board[r-1][c+1];
            }
            
            result += board[r-1][c];
        }
        
        if (r < board.length-1) {
            if (c > 0) {
                result += board[r+1][c-1];
            }
            
            if (c < board[0].length-1) {
                result += board[r+1][c+1];
            }
            
            result += board[r+1][c];
        }
        
        if (c > 0) {
            result += board[r][c-1];
        }
        
        if (c < board[0].length-1) {
            result += board[r][c+1];
        }
        
        return result;
    }
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] neighbors = new int[m][n];          // 주변 살아있는 셀 개수를 담을 배열
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                neighbors[i][j] = countNeighbors(board, i, j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && neighbors[i][j] == 3) {         // 문제에 제시된 조건에 따라 갱신
                    board[i][j] = 1;
                    continue;
                }
                
                if (neighbors[i][j] < 2 || neighbors[i][j] > 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
Memory Usage: 40.3 MB, less than 97.58% of Java online submissions for Game of Life.
*/
