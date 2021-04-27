/*
1582.
Special Positions in a Binary Matrix
https://leetcode.com/problems/special-positions-in-a-binary-matrix/
*/

class Solution {
    public int numSpecial(int[][] mat) {
        int[] rowsCount = new int[mat.length];
        int[] colsCount = new int[mat[0].length];
        int answer = 0;
        for (int i = 0; i < mat.length; i++) {              // mat을 탐색하며 1을 발견하면 해당 행과 열의 카운트를 증가
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rowsCount[i]++;
                    colsCount[j]++;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {              // 해당 값이 1이고 행/열 카운트 또한 1일 경우 answer 증가
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && rowsCount[i] == 1 && colsCount[j] == 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

/*
Runtime: 1 ms, faster than 99.64% of Java online submissions for Special Positions in a Binary Matrix.
Memory Usage: 38.9 MB, less than 78.25% of Java online submissions for Special Positions in a Binary Matrix.
*/
