/*
1014.
Best Sightseeing Pair
https://leetcode.com/problems/best-sightseeing-pair/
*/

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int answer = Integer.MIN_VALUE;
        int max = values[0];        // values[i] + i의 최대값
        for(int j = 1; j < values.length; j++) {
            answer = Math.max(answer, max + values[j] - j);     // values[i] + i의 최대값에서 현재 요소인 values[j] - j를 뺀 값이 최대가 되도록 갱신
            max = Math.max(max, values[j] + j);             // max 갱신
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 62.04% of Java online submissions for Best Sightseeing Pair.
Memory Usage: 64.5 MB, less than 21.36% of Java online submissions for Best Sightseeing Pair.
*/
