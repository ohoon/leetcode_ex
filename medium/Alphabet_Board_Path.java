/*
1138.
Alphabet Board Path
https://leetcode.com/problems/alphabet-board-path/
*/

class Solution {
    private String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
    
    private int[] getPos(char c) {          // board에서의 문자 c의 위치를 반환해주는 함수
        int[] pos = {-1, -1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == c) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        
        return pos;
    }
    
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int[] cur = {0, 0};
        for (char c : target.toCharArray()) {
            int[] next = getPos(c);                                 // 다음 문자가 올 위치
            while (cur[0] != next[0] || cur[1] != next[1]) {        // cur이 다음 위치가 될 때까지 반복
                if (cur[0] > next[0]) {     // up 처리
                    sb.append('U');
                    cur[0]--;
                    continue;
                }
                
                if (cur[0] < next[0] && !(cur[0] == 4 && cur[1] > 0)) {     // down 처리, cur이 v, w, x, y를 가리킬 경우에는 down할 수 없음
                    sb.append('D');
                    cur[0]++;
                    continue;
                }
                
                if (cur[1] > next[1]) {     // left 처리
                    sb.append('L');
                    cur[1]--;
                    continue;
                }
                
                if (cur[1] < next[1] && cur[0] != 5) {      // right 처리, cur이 z를 가리킬 경우에는 right할 수 없음
                    sb.append('R');
                    cur[1]++;
                    continue;
                }
            }
            
            sb.append('!');     // 클릭 처리
        }
        
        return sb.toString();
    }
}

/*
Runtime: 1 ms, faster than 64.78% of Java online submissions for Alphabet Board Path.
Memory Usage: 39.1 MB, less than 21.59% of Java online submissions for Alphabet Board Path.
*/
