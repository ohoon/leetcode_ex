/*
495.
Teemo Attacking
https://leetcode.com/problems/teemo-attacking/
*/

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int answer = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            answer += duration;
            
            if (i > 0 && timeSeries[i] <= timeSeries[i-1] + duration - 1) {     // 독 감염 시간이 겹치는 경우 겹치는 시간 만큼 answer에서 감소
                answer -= timeSeries[i-1] - timeSeries[i] + duration;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 59.74% of Java online submissions for Teemo Attacking.
Memory Usage: 40.6 MB, less than 81.83% of Java online submissions for Teemo Attacking.
*/
