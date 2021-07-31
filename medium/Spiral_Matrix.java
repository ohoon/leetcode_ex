/*
54.
Spiral Matrix
https://leetcode.com/problems/spiral-matrix/
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0, stage = 0;
        for (int l = 0; l < m*n; l++) {
            answer.add(matrix[i][j]);
            matrix[i][j] = -101;        // 방문한 요소의 값을 -101로 변경
            switch (stage % 4) {
                case 0:
                    if (j + 1 == n || matrix[i][j+1] == -101) {
                        stage++;
                        i++;
                    } else {
                        j++;
                    }

                    break;
                case 1:
                    if (i + 1 == m || matrix[i+1][j] == -101) {
                        stage++;
                        j--;
                    } else {
                        i++;
                    }

                    break;
                case 2:
                    if (j == 0 || matrix[i][j-1] == -101) {
                        stage++;
                        i--;
                    } else {
                        j--;
                    }

                    break;
                case 3:
                    if (i == 0 || matrix[i-1][j] == -101) {
                        stage++;
                        j++;
                    } else {
                        i--;
                    }

                    break;
            }
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
Memory Usage: 37.4 MB, less than 38.48% of Java online submissions for Spiral Matrix.
*/

/*
다른 풀이

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
}

내 코드에서 마음에 들지 않은 부분이 쓸데없이 중복되는 코드들이 많은 것과 원래의 배열을 수정해야하는 점이었는데,
이 풀이에선 저 부분을 아주 명쾌하게 해결해주었다.
seen이라는 불린 배열을 하나 만들어서 해당 요소를 방문했었는지 판단할 수 있도록 하였고,
dr, dc 배열을 추가함으로써 4가지 케이스를 공통적인 로직으로 묶을 수가 있었다.
이렇게 깔끔하게 코드를 짜는 스킬을 배워야하는데 참 아쉽다.

 */
