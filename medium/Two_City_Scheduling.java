/*
1029.
Two City Scheduling
https://leetcode.com/problems/two-city-scheduling/
*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int answer = 0;
        int n = costs.length / 2;
        Arrays.sort(costs, (x, y) -> (x[0] - x[1]) - (y[0] - y[1]));        // A도시로 이동하는 cost가 B도시로 이동하는 cost보다 더 작을수록 앞으로 감
        for (int i = 0; i < n; i++) {       // 위에서 정렬한 배열 기준으로 절반으로 나누어 계산 (A도시로 가는게 효율적 | B도시로 가는게 효율적)
            answer += costs[i][0];
        }
        
        for (int i = n; i < 2*n; i++) {
            answer += costs[i][1];
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 17.94% of Java online submissions for Two City Scheduling.
Memory Usage: 42.4 MB, less than 35.47% of Java online submissions for Two City Scheduling.
*/
