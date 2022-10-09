/*
2432.
The Employee That Worked on the Longest Task
https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/
*/

class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int answer = logs[0][0], max = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int dur = logs[i][1] - logs[i-1][1];
            if (dur > max || (dur == max && logs[i][0] < answer)) {
                max = dur;
                answer = logs[i][0];
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for The Employee That Worked on the Longest Task.
Memory Usage: 42.2 MB, less than 100.00% of Java online submissions for The Employee That Worked on the Longest Task.
*/
