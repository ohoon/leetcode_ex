/*
994.
Rotting Oranges
https://leetcode.com/problems/rotting-oranges/
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> deq = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int count = 0;      // 남은 싱싱한 오렌지 개수
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    continue;
                }
                
                if (grid[i][j] == 2) {      // 썩은 오렌지 위치 정보를 deque에 삽입
                    deq.offer(new int[]{i, j});
                }
            }
        }
        
        int answer = 0;
        while (!deq.isEmpty()) {       // rotten 전파가 끊기지 전까지 계속 반복
            int size = deq.size();
            for (int i = 0; i < size; i++) {
                int[] cell = deq.poll();
                int r = cell[0], c = cell[1];
                if (r > 0 && grid[r-1][c] == 1) {       // 썩은 오렌지를 기준으로 상하좌우 싱싱한 오렌지를 썩게 만듦
                    grid[r-1][c] = 2;
                    deq.offer(new int[]{r-1, c});
                    count--;
                }
                
                if (c > 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    deq.offer(new int[]{r, c-1});
                    count--;
                }
                
                if (r < m-1 && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    deq.offer(new int[]{r+1, c});
                    count--;
                }
                
                if (c < n-1 && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    deq.offer(new int[]{r, c+1});
                    count--;
                }
            }
            
            if (!deq.isEmpty()) {
                answer++;
            }
        }
        
        return count == 0 ? answer : -1;        // 모든 오렌지를 썩게 만들지 못하면 -1 
    }
}

/*
Runtime: 3 ms, faster than 66.77% of Java online submissions for Rotting Oranges.
Memory Usage: 42.7 MB, less than 60.40% of Java online submissions for Rotting Oranges.
*/
