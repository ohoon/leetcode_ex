/*
419.
Battleships in a Board
https://leetcode.com/problems/3sum/
*/

class Solution {
    public int countBattleships(char[][] board) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {       // 배틀쉽을 발견하면 answer 증가
                    answer++;
                    dfs(board, i, j);           // 배틀쉽의 첫 cell을 기준으로 연결된 모든 cell을 .으로 변경
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '.') {        // 인덱스 범위를 벗어나거나 배틀쉽이 아닌 cell은 탐색하지 않음
            return;
        }
        
        board[i][j] = '.';      // 현재 cell을 empty cell로 바꾸고 4방향으로 순회
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}

/*
Runtime: 1 ms, faster than 43.19% of Java online submissions for Battleships in a Board.
Memory Usage: 41.2 MB, less than 9.90% of Java online submissions for Battleships in a Board.
*/
