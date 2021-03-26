/*
1184.
Distance Between Bus Stops
https://leetcode.com/problems/distance-between-bus-stops/
*/

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        
        if (start > destination) {          // swap
            int temp = start;
            start = destination;
            destination = temp;
        }
        
        int direct = 0;                     // 직행 코스 (start와 destination 사이의 거리들 합)
        int indirect = 0;                   // 돌아가는 코스  (나머지 거리들의 합)
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {        // 직행 코스의 경우
                direct += distance[i];
            } else {                                    // 돌아가는 코스의 경우
                indirect += distance[i];
            }
        }
        
        return Math.min(direct, indirect);              // 가까운 거리 값 반환
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Distance Between Bus Stops.
Memory Usage: 39.1 MB, less than 25.05% of Java online submissions for Distance Between Bus Stops.
*/
