/*
1605.
Find Valid Matrix Given Row and Column Sums
https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
*/

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {      // greedy
        int m = rowSum.length;
        int n = colSum.length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = Math.min(rowSum[i], colSum[j]);      // 해당 요소와 연관되는 rowSum과 colSum의 한계를 벗어나지 않는 시점에서 가장 큰 수를 배치
                rowSum[i] -= answer[i][j];
                colSum[j] -= answer[i][j];
            }
        }
        
        return answer;
    }
}

/*
Runtime: 14 ms, faster than 25.31% of Java online submissions for Find Valid Matrix Given Row and Column Sums.
Memory Usage: 121.4 MB, less than 12.28% of Java online submissions for Find Valid Matrix Given Row and Column Sums.
*/
