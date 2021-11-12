/*
1706.
Where Will the Ball Fall
https://leetcode.com/problems/where-will-the-ball-fall/
*/

class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int r = 0, c = i;
            boolean isStucked = false;                      // 고립된 상태인지 아닌지
            while (r < m) {                                 // 무사히 통과할 때까지 반복
                if ((c == 0 && grid[r][c] == -1) ||         // 왼쪽 벽에 고립될 경우
                    (c == n-1 && grid[r][c] == 1) ||        // 오른쪽 벽에 고립될 경우
                    (c > 0 && grid[r][c] == -1 && grid[r][c-1] == 1) ||     // V자 모양으로 고립될 경우
                    (c < n-1 && grid[r][c] == 1 && grid[r][c+1] == -1)) {
                    isStucked = true;
                    break;
                }
                
                c += grid[r++][c];          // 정상적으로 진행되면 row를 증가시키고 col값을 현재 기울기에 따라 변경
            }
            
            answer[i] = isStucked ? -1 : c;     // 정상적으로 통과되면 col값을 answer[i]에 저장
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 30.39% of Java online submissions for Where Will the Ball Fall.
Memory Usage: 40.3 MB, less than 73.91% of Java online submissions for Where Will the Ball Fall.
*/
