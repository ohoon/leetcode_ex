/*
1637.
Widest Vertical Area Between Two Points Containing No Points
https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
*/

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int answer = 0;
        Arrays.sort(points, (x, y) -> x[0] - y[0]);     // x축 값 기준으로 오름차순 정렬
        for (int i = 0; i < points.length - 1; i++) {
            answer = Math.max(answer, points[i+1][0] - points[i][0]);
        }
        
        return answer;
    }
}

/*
Runtime: 50 ms, faster than 55.03% of Java online submissions for Widest Vertical Area Between Two Points Containing No Points.
Memory Usage: 70.4 MB, less than 88.76% of Java online submissions for Widest Vertical Area Between Two Points Containing No Points.
*/
