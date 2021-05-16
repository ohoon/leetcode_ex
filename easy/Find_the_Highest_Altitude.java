/*
1732.
Find the Highest Altitude
https://leetcode.com/problems/find-the-highest-altitude/
*/

class Solution {
    public int largestAltitude(int[] gain) {
        int answer = 0;
        int altitude = 0;       // 고도
        for (int g : gain) {
            altitude += g;      // 고도 갱신
            answer = Math.max(answer, altitude);        // 최댓값 갱신
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Highest Altitude.
Memory Usage: 36.8 MB, less than 28.26% of Java online submissions for Find the Highest Altitude.
*/
