/*
2133.
Check if Every Row and Column Contains All Numbers
https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
*/

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        Set<Integer> row = new HashSet<>();     // 행 방향의 원소를 관리하는 set
        Set<Integer> col = new HashSet<>();     // 열 방향의 원소를 관리하는 set
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row.add(matrix[i][j]);          // 각 방향별로 데이터를 삽입
                col.add(matrix[j][i]);
            }
            
            if (row.size() != n || col.size() != n) {       // 중복된 수가 있으면 false 반환
                return false;
            }
            
            row.clear();
            col.clear();
        }
        
        return true;
    }
}

/*
Runtime: 19 ms, faster than 14.29% of Java online submissions for Check if Every Row and Column Contains All Numbers.
Memory Usage: 40.6 MB, less than 14.29% of Java online submissions for Check if Every Row and Column Contains All Numbers.
*/
