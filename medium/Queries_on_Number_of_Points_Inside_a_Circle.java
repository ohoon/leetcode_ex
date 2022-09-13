/*
1828.
Queries on Number of Points Inside a Circle
https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
*/

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {     // math
        int[] answer = new int[queries.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < queries.length; j++) {
                if (Math.pow((points[i][0]-queries[j][0]), 2) + Math.pow((points[i][1]-queries[j][1]), 2) <= Math.pow(queries[j][2], 2)) {   // (x-a)^2 + (y-b)^2 <= c^2
                    answer[j]++;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 60 ms, faster than 27.52% of Java online submissions for Queries on Number of Points Inside a Circle.
Memory Usage: 50.8 MB, less than 24.65% of Java online submissions for Queries on Number of Points Inside a Circle.
*/
