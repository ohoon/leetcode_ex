/*
1292.
Maximum Side Length of a Square with Sum Less than or Equal to Threshold
https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
*/

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {      // prefix sum
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {      // 행 별로 prefix sum 계산
                prefix[i][j] = prefix[i][j-1] + mat[i][j-1];
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int side = 1; side <= Math.min(m-i, n-j); side++) {        // 변 길이 1부터 차례대로 늘려감
                    int sum = 0;
                    for (int row = i; row < i+side; row++) {        // 행 별로 sum 값을 더하여 threshold 검사
                        sum += mat[row][j+side-1] + prefix[row][j+side-1] - prefix[row][j];
                    }

                    if (sum > threshold) {
                        break;
                    }

                    answer = Math.max(answer, side);
                }
            }
        }

        return answer;
    }
}
