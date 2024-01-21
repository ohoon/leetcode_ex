/*
2639.
Find the Width of Columns of a Grid
https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/
*/

class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] answer = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                answer[i] = Math.max(answer[i], String.valueOf(grid[j][i]).length());
            }
        }

        return answer;
    }
}
