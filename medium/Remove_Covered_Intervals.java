/*
1288.
Remove Covered Intervals
https://leetcode.com/problems/remove-covered-intervals/
*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] != y[0] ? x[0] - y[0] : y[1] - x[1]);     // 시작지점을 기준으로 오름차순 정렬, 시작지점이 같으면 끝지점이 더 먼 interval이 앞에 옴
        int answer = 1, prev = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[1] <= prev) {          // 이전 범위 안에 해당 interval이 들어가면 패스
                continue;
            }
            
            prev = interval[1];         // prev를 갱신
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 97.15% of Java online submissions for Remove Covered Intervals.
Memory Usage: 42.5 MB, less than 84.29% of Java online submissions for Remove Covered Intervals.
*/
