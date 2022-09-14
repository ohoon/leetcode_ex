/*
807.
Max Increase to Keep City Skyline
https://leetcode.com/problems/max-increase-to-keep-city-skyline/
*/

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];      // 행 기준 최대값
        int[] colMax = new int[n];      // 열 기준 최대값
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);        // 최대값 갱신
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += Math.min(rowMax[i], colMax[j]) - grid[i][j];      // 해당 행, 열 최대값중에 작은 값이 최대로 키울 수 있는 건물 크기
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 89.94% of Java online submissions for Max Increase to Keep City Skyline.
Memory Usage: 44.4 MB, less than 40.62% of Java online submissions for Max Increase to Keep City Skyline.
*/
