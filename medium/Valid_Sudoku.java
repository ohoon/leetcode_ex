/*
36.
Valid Sudoku
https://leetcode.com/problems/valid-sudoku/
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {           // 빈칸이 아닌 경우
                    if (!set.add("r" + i + "-" + board[i][j]) ||        // 각 행, 열, 박스에 중복 데이터가 존재하면 false 반환
                       !set.add("c" + j + "-" + board[i][j]) ||
                       !set.add("b" + (3 * (i / 3) + (j / 3)) + "-" + board[i][j])) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}

/*
Runtime: 13 ms, faster than 29.32% of Java online submissions for Valid Sudoku.
Memory Usage: 44.9 MB, less than 5.43% of Java online submissions for Valid Sudoku.
*/

/*
다른 사람의 풀이

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    if(!isValid(board,i,j,board[i][j]))
                        return false;
                }
            }
         }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char num){

        //for row checking
        for(int i=col+1;i<9;i++){
            if(board[row][i] == num)
                return false;
        }

        //For col checking
        for(int i=row+1;i<9;i++){
            if(board[i][col] == num)
                return false;
        }

        //for internal square
        int x = row - row%3, y = col-col%3;
        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                if(board[i][j]==num && !(i==row && j==col))
                    return false;
            }
        }   
        return true;
    }   
}

set과 같이 중복을 자료구조를 이용해서 처리하는 것이 아니라
하나의 원소마다 행과 열, 박스를 직접 탐색하는 것으로 중복을 찾아 해결하는 코드다.
내가 이 문제를 풀려고 할 때 이런 방법은 시간적으로 비효율적이라고 생각해서 작성하지 않은 코드였는데
의외로 이런 코드가 속도가 오히려 좋게 나와서 당황스러웠다.
입력값의 크기가 작을 경우에는 이러한 간단하고 직관적인 방법이 오히려 좋은 방법이 될 수도 있다는 것임을 깨달았다.

*/
