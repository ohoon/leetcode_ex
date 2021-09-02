/*
529.
Minesweeper
https://leetcode.com/problems/minesweeper/
*/

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        sub(board, click[0], click[1]);
        return board;
    }

    private void sub(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }

        switch (board[row][col]) {
            case 'M':       // 지뢰를 밟으면 X로 바꾸고 종료
                board[row][col] = 'X';
                return;
            case 'E':       // 지뢰가 아닌 칸을 밟으면 주변 지뢰 개수를 count
                int count = 0;
                for (int i = row-1; i <= row+1; i++) {
                    if (i < 0 || i >= board.length) {
                        continue;
                    }

                    for (int j = col-1; j <= col+1; j++) {
                        if (j < 0 || j >= board[0].length) {
                            continue;
                        }

                        if (board[i][j] == 'M') {
                            count++;
                        }
                    }
                }

                if (count > 0) {        // 주변 지뢰 개수가 1개 이상이면 개수를 표시하고 종료
                    board[row][col] = (char) ('0' + count);
                    return;
                }

                board[row][col] = 'B';  // 주변 지뢰 개수가 0개라면 주변 칸을 순회하여 재탐색
                for (int i = row-1; i <= row+1; i++) {
                    if (i < 0 || i >= board.length) {
                        continue;
                    }

                    for (int j = col-1; j <= col+1; j++) {
                        if (j < 0 || j >= board[0].length) {
                            continue;
                        }

                        sub(board, i, j);
                    }
                }
        }
    }
}

/*
Runtime: 1 ms, faster than 47.60% of Java online submissions for Minesweeper.
Memory Usage: 51.9 MB, less than 6.82% of Java online submissions for Minesweeper.
*/
