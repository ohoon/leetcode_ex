/*
1222.
Queens That Can Attack the King
https://leetcode.com/problems/queens-that-can-attack-the-king/
*/

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] board = new boolean[8][8];
        for (int[] q : queens) {
            board[q[0]][q[1]] = true;
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] dir = new boolean[8];
        for (int i = 1; i < 8; i++) {
            int r = king[0], c = king[1];
            if (!dir[0] && r >= i && c >= i && board[r-i][c-i]) {
                answer.add(Arrays.asList(new Integer[]{r-i, c-i}));
                dir[0] = true;
            }
            
            if (!dir[1] && r >= i && board[r-i][c]) {
                answer.add(Arrays.asList(new Integer[]{r-i, c}));
                dir[1] = true;
            }
                        
            if (!dir[2] && r >= i && c < 8-i && board[r-i][c+i]) {
                answer.add(Arrays.asList(new Integer[]{r-i, c+i}));
                dir[2] = true;
            }
                        
            if (!dir[3] && c < 8-i && board[r][c+i]) {
                answer.add(Arrays.asList(new Integer[]{r, c+i}));
                dir[3] = true;
            }
                        
            if (!dir[4] && r < 8-i && c < 8-i && board[r+i][c+i]) {
                answer.add(Arrays.asList(new Integer[]{r+i, c+i}));
                dir[4] = true;
            }
                        
            if (!dir[5] && r < 8-i && board[r+i][c]) {
                answer.add(Arrays.asList(new Integer[]{r+i, c}));
                dir[5] = true;
            }
                        
            if (!dir[6] && r < 8-i && c >= i && board[r+i][c-i]) {
                answer.add(Arrays.asList(new Integer[]{r+i, c-i}));
                dir[6] = true;
            }
                        
            if (!dir[7] && c >= i && board[r][c-i]) {
                answer.add(Arrays.asList(new Integer[]{r, c-i}));
                dir[7] = true;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 98.01% of Java online submissions for Queens That Can Attack the King.
Memory Usage: 42.1 MB, less than 98.01% of Java online submissions for Queens That Can Attack the King.
*/
