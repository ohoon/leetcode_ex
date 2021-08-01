/*
59.
Spiral Matrix II
https://leetcode.com/problems/spiral-matrix-ii/
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int[] dr = {0, 1, 0, -1};           // row기준 4가지 방향
        int[] dc = {1, 0, -1, 0};           // col기준 4가지 방향
        int i = 0, j = 0, stage = 0;
        for (int l = 1; l <= n*n; l++) {
            int nextI = i + dr[stage];      // 다음 row 인덱스
            int nextJ = j + dc[stage];      // 다음 col 인덱스
            answer[i][j] = l;
            if (nextI < 0 ||                // 다음 인덱스에 충돌이 일어날 경우 stage를 증가시켜 방향 변경
                nextJ < 0 ||
                nextI >= n ||
                nextJ >= n ||
                answer[nextI][nextJ] > 0) {
                
                stage = (stage + 1) % 4;
            }
            
            i += dr[stage];                 // 실제 인덱스 갱신
            j += dc[stage];
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
Memory Usage: 37.3 MB, less than 40.95% of Java online submissions for Spiral Matrix II.
*/
