/*
1926.
Nearest Exit from Entrance in Maze
https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
*/

class Solution {
    private boolean isExit(char[][] maze, int r, int c) {           // 해당 위치가 탈출구의 위치인지 알려주는 메서드
        return r == 0 || 
            r == maze.length - 1 || 
            c == 0 || 
            c == maze[0].length - 1;
    }
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int answer = 0;                             // 걸음수
        Queue<int[]> q = new LinkedList<>();        // 선입선출
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';       // 입구는 +으로 막아버림
        while (!q.isEmpty()) {
            answer++;
            int len = q.size();
            for (int i = 0; i < len; i++) {         // 현재 큐에 들어있는 요소만큼만 poll해서 사용
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                if (r > 0 && maze[r-1][c] == '.') { // 상
                    if (isExit(maze, r-1, c)) {     // 탈출구를 발견하면 바로 현재 걸음수를 반환
                        return answer;
                    }
                    
                    q.offer(new int[]{r-1, c});     // 다음으로 이동해야 하는 셀 정보를 큐에 삽입
                    maze[r-1][c] = '+';             // 같은 셀이 중복으로 큐에 삽입되는 경우를 막기 위해 미리 막아둠
                }
                
                if (r < maze.length - 1 && maze[r+1][c] == '.') {   // 하
                    if (isExit(maze, r+1, c)) {
                        return answer;
                    }
                    
                    q.offer(new int[]{r+1, c});
                    maze[r+1][c] = '+';
                }
                
                if (c > 0 && maze[r][c-1] == '.') {     // 좌
                    if (isExit(maze, r, c-1)) {
                        return answer;
                    }
                    
                    q.offer(new int[]{r, c-1});
                    maze[r][c-1] = '+';
                }
                
                if (c < maze[0].length - 1 && maze[r][c+1] == '.') {        // 우
                    if (isExit(maze, r, c+1)) {
                        return answer;
                    }
                    
                    q.offer(new int[]{r, c+1});
                    maze[r][c+1] = '+';
                }
            }
        }
        
        return -1;      // 탈출구를 끝내 발견하지 못하고 막다른 길에 다다르면 -1 반환
    }
}

/*
Runtime: 5 ms, faster than 91.04% of Java online submissions for Nearest Exit from Entrance in Maze.
Memory Usage: 40.8 MB, less than 39.43% of Java online submissions for Nearest Exit from Entrance in Maze.
*/

/*
여담

오랜만에 bfs를 사용해서 코드가 좀 지저분하고 오래걸린 면이 없지않아 있다.
주로 dfs만 사용하다보니 최단 경로를 구하는 문제에선 bfs를 써야한다는 것을 까먹었던 듯..

*/
