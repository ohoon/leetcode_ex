/*
1351.
Count Negative Numbers in a Sorted Matrix
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
*/

class Solution {
    public int countNegatives(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {               // 음수를 발견하면 남은 요소들의 개수를 answer에 더하고 다음 행으로
                    answer += grid[0].length - j;
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Check If It Is a Straight Line.
Memory Usage: 38.6 MB, less than 61.62% of Java online submissions for Check If It Is a Straight Line.
*/
