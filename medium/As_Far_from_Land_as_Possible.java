/*
1162.
As Far from Land as Possible
https://leetcode.com/problems/as-far-from-land-as-possible/
*/

class Solution {
    public int maxDistance(int[][] grid) {      // BFS
        int n = grid.length;
        Deque<int[]> deq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                
                deq.offer(new int[]{i, j});
            }
        }

        if (deq.isEmpty() || deq.size() == n*n) {       // only water 또는 only land일 경우 -1
            return -1;
        }

        int answer = -1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!deq.isEmpty()) {
            int size = deq.size();
            for (int i = 0; i < size; i++) {
                int[] p = deq.poll();
                int x = p[0], y = p[1];
                for (int[] dir : dirs) {
                    int r = x + dir[0], c = y + dir[1];
                    if (r < 0 || r == n || c < 0 || c == n || grid[r][c] == 1) {
                        continue;
                    }

                    grid[r][c] = 1;
                    deq.offer(new int[]{r, c});
                }
            }

            answer++;
        }

        return answer;
    }
}
