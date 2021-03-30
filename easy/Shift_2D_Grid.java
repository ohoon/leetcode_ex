/*
1260.
Shift 2D Grid
https://leetcode.com/problems/shift-2d-grid/
*/

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int index = n * i + j - k;              // 해당 자리에 들어갈 요소의 위치를 1차원으로 변환한 인덱스
                while (index < 0) {                     // 인덱스가 양수가 될 때까지 m*n만큼 더함
                    index += m * n;
                }
                
                int row = index / n;                    // 인덱스를 열 크기만큼 나눈 몫 = 행 위치
                int col = index % n;                    // 인덱스를 열 크기만큼 나눈 나머지 = 열 위치
                temp.add(grid[row][col]);               // k 전의 요소를 해당 위치에 삽입
            }
            
            answer.add(temp);
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 86.32% of Java online submissions for Shift 2D Grid.
Memory Usage: 39.5 MB, less than 96.96% of Java online submissions for Shift 2D Grid.
*/
