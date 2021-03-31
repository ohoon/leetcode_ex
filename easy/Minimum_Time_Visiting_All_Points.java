/*
1266.
Minimum Time Visiting All Points
https://leetcode.com/problems/minimum-time-visiting-all-points/
*/

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int answer = 0;
        for (int i = 1; i < points.length; i++) {
            int diffX = Math.abs(points[i][0] - points[i-1][0]);
            int diffY = Math.abs(points[i][1] - points[i-1][1]);
            
            answer += Math.max(diffX, diffY);
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Time Visiting All Points.
Memory Usage: 38.5 MB, less than 62.79% of Java online submissions for Minimum Time Visiting All Points.
*/
