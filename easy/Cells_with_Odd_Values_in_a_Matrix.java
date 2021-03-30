/*
1252.
Cells with Odd Values in a Matrix
https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
*/

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int answer = 0;
        int[] rows = new int[m];            // 각 행별 증가량
        int[] cols = new int[n];            // 각 열별 증가량
        for (int[] idc : indices) {         // indices에 해당하는 행, 열의 증가량 기록
            int row = idc[0];
            int col = idc[1];
            rows[row]++;
            cols[col]++;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int result = rows[i] + cols[j];     // 해당 셀의 값 = 해당 행의 증가량 + 해당 열의 증가량
                if (result % 2 != 0) {              // 홀수면 answer + 1
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 81.62% of Java online submissions for Cells with Odd Values in a Matrix.
Memory Usage: 36.7 MB, less than 92.82% of Java online submissions for Cells with Odd Values in a Matrix.
*/

/*
여담

시간복잡도를 O(m+n)으로 하기위해서 무슨 방법이 있을까 고민하다가 답이 안나와서 다른 사람 풀이를 보고 방법을 터득하기로 함
m x n 공간에서 연산을 하지 않고 m 배열, n 배열 따로 나눠서 연산하는 식으로 풀이했다.

*/
