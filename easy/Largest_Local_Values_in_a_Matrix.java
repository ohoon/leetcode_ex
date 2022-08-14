/*
2373.
Largest Local Values in a Matrix
https://leetcode.com/problems/largest-local-values-in-a-matrix/
*/

class Solution {
    public int[][] largestLocal(int[][] grid) {         // bruteforce
        int n = grid.length;
        int[][] answer = new int[n-2][n-2];
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) {
                int max = 0;
                for (int k = i; k <= i+2; k++) {
                    for (int l = j; l <= j+2; l++) {
                        max = Math.max(max, grid[k][l]);
                    }
                }
                
                answer[i][j] = max;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 25.00% of Java online submissions for Largest Local Values in a Matrix.
Memory Usage: 51.6 MB, less than 50.00% of Java online submissions for Largest Local Values in a Matrix.
*/
