/*
1267.
Count Servers that Communicate
https://leetcode.com/problems/count-servers-that-communicate/
*/

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {       // 행, 열별로 몇개의 서버가 있는지 카운팅
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                
                rows[i]++;
                cols[j]++;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                
                if (rows[i] > 1 || cols[j] > 1) {       // 같은 행, 열에 서버가 2개 이상이면 communicate가 가능한 서버이므로 answer 증가
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 99.77% of Java online submissions for Count Servers that Communicate.
Memory Usage: 64.8 MB, less than 54.30% of Java online submissions for Count Servers that Communicate.
*/
