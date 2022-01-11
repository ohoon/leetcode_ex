/*
1936.
Add Minimum Number of Rungs
https://leetcode.com/problems/add-minimum-number-of-rungs/
*/

class Solution {
    public int addRungs(int[] rungs, int dist) {
        int answer = 0;     // 필요한 rung 개수
        int curr = 0;       // 현재 위치
        for (int r : rungs) {
            if (curr + dist < r) {      // rung이 필요한 경우
                answer += (r - curr - 1) / dist;        // (r까지 가는데 필요한 거리 - 1) / dist = 필요한 rung의 개수
            }
            
            curr = r;       // 위치 갱신
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Minimum Number of Rungs.
Memory Usage: 80 MB, less than 30.29% of Java online submissions for Add Minimum Number of Rungs.
*/
