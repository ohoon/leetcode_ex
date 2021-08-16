/*
130.
Surrounded Regions
https://leetcode.com/problems/surrounded-regions/
*/

class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] isNotCaptured = new boolean[m][n];          // 고립되지 않은 땅 마킹용
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' || isNotCaptured[i][j]) {    // 이미 마킹되어 있는 땅의 경우엔 생략
                    continue;
                }

                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {    // 테두리에 있는 땅을 시작점으로 깊이 우선 탐색으로 마킹
                    dfs(board, i, j, isNotCaptured);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !isNotCaptured[i][j]) {       // 마킹되어 있지 않은 땅은 X로 대체
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] isNotCaptured) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 'X' || isNotCaptured[i][j]) {
            return;
        }

        isNotCaptured[i][j] = true;         // 마킹을 하고 네 방향으로 깊이 우선으로 전개
        dfs(board, i-1, j, isNotCaptured);
        dfs(board, i+1, j, isNotCaptured);
        dfs(board, i, j-1, isNotCaptured);
        dfs(board, i, j+1, isNotCaptured);
    }
}

/*
Runtime: 2 ms, faster than 53.10% of Java online submissions for Surrounded Regions.
Memory Usage: 40.9 MB, less than 85.75% of Java online submissions for Surrounded Regions.
*/

/*
여담

엄청 어려운 느낌의 문제는 아니었던거 같은데
삽질을 많이 해서 그런가 푸는데 시간이 1시간 반가량 걸렸다..
좀 더 빠르게 풀이할 수 있도록 해야겠다.

*/
