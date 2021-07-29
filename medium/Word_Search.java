/*
79.
Word Search
https://leetcode.com/problems/word-search/
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (sub(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean sub(char[][] board, String word, int i, int j, int curr) {
        if (curr == word.length()) {        // 모든 word를 찾으면 true 반환
            return true;
        }
        
        if (i < 0 ||
            i == board.length ||
            j < 0 ||
            j == board[0].length ||
            board[i][j] != word.charAt(curr)) {     // i, j가 인덱스 범위를 벗어나거나 현재 board[i][j]가 찾고자 하는 문자가 아닐 경우 false 반환
            return false;
        }
        
        char temp = board[i][j];        // 백업용
        board[i][j] = '-';              // 찾은 것은 - 처리
        boolean result = sub(board, word, i+1, j, curr+1) ||        // 상하좌우로 다음 문자를 탐색한 결과를 저장
            sub(board, word, i-1, j, curr+1) ||
            sub(board, word, i, j+1, curr+1) ||
            sub(board, word, i, j-1, curr+1);
        board[i][j] = temp;             // 탐색이 끝나면 다시 복구
        
        return result;
    }
}

/*
Runtime: 97 ms, faster than 52.32% of Java online submissions for Word Search.
Memory Usage: 36.9 MB, less than 80.74% of Java online submissions for Word Search.
*/
