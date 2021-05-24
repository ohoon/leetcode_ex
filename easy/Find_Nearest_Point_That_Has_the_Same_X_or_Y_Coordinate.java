/*
1779.
Find Nearest Point That Has the Same X or Y Coordinate
https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
*/

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int answer = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x && min > Math.abs(points[i][1] - y)) {    // x좌표가 일치하고 맨하탄 거리가 최솟값보다 작을 경우
                min = Math.min(min, Math.abs(points[i][1] - y));
                answer = i;
                continue;
            }

            if (points[i][1] == y && min > Math.abs(points[i][0] - x)) {    // y좌표가 일치하고 맨하탄 거리가 최솟값보다 작을 경우
                min = Math.min(min, Math.abs(points[i][0] - x));
                answer = i;
                continue;
            }
        }

        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Nearest Point That Has the Same X or Y Coordinate.
Memory Usage: 46.3 MB, less than 89.88% of Java online submissions for Find Nearest Point That Has the Same X or Y Coordinate.
*/
