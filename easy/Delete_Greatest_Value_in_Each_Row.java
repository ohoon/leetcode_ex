/*
2500.
Delete Greatest Value in Each Row
https://leetcode.com/problems/delete-greatest-value-in-each-row/
*/

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int answer = 0;
        for (int i = n-1; i >= 0; i--) {
            int max = grid[0][i];
            for (int j = 1; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }

            answer += max;
        }

        return answer;
    }
}
