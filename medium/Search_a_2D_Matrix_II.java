/*
240.
Search a 2D Matrix II
https://leetcode.com/problems/search-a-2d-matrix-ii/
*/

class Solution {
    private boolean dfs(int[][] matrix, int r, int c, int target, boolean[][] visited) {        // 깊이 우선 탐색
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || visited[r][c]) {       // 인덱스 범위를 벗어나거나 이미 방문한 셀인 경우 false 반환
            return false;
        }
        
        visited[r][c] = true;               // 방문 표시
        if (matrix[r][c] == target) {       // target을 찾으면 true 반환
            return true;
        }
        
        if (matrix[r][c] > target) {        // 현재 셀이 target보다 커서 더 이상 탐색이 불가능하면 false 반환
            return false;
        }
        
        return dfs(matrix, r, c+1, target, visited) || dfs(matrix, r+1, c, target, visited);        // 오른쪽과 아래 방향으로 깊이 우선 탐색
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        return dfs(matrix, 0, 0, target, new boolean[matrix.length][matrix[0].length]);
    }
}

/*
Runtime: 92 ms, faster than 5.10% of Java online submissions for Search a 2D Matrix II.
Memory Usage: 62.7 MB, less than 5.18% of Java online submissions for Search a 2D Matrix II.
*/
