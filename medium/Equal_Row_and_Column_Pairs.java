/*
2352.
Equal Row and Column Pairs
https://leetcode.com/problems/equal-row-and-column-pairs/
*/

class Solution {
    private boolean isEqual(int[] arr1, int[] arr2) {       // 두 배열의 값이 동일한지 확인하는 메서드
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] trans = new int[n][n];          // grid를 column 기준으로 전이한 2차원 배열
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                trans[j][i] = grid[i][j];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isEqual(grid[i], trans[j])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 51 ms, faster than 71.91% of Java online submissions for Equal Row and Column Pairs.
Memory Usage: 70.7 MB, less than 63.27% of Java online submissions for Equal Row and Column Pairs.
*/
