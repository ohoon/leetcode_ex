/*
452.
Minimum Number of Arrows to Burst Balloons
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
*/

class Solution {
    public int findMinArrowShots(int[][] points) {      // greedy
        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));     // 끝점 기준으로 오름차순 정렬
        int answer = 0;
        Integer prev = null;        // 이전 끝점
        for (int i = 0; i < points.length; i++) {
            if (prev != null && points[i][0] <= prev) {     // 현재 시작점이 이전 끝점 이하라면 이전 풍선 범위 안에 포함되므로 카운팅하지 않아도 됨
                continue;
            }
            
            prev = points[i][1];
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 69 ms, faster than 83.79% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
Memory Usage: 74.8 MB, less than 98.34% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
*/
