/*
1688.
Count of Matches in Tournament
https://leetcode.com/problems/count-of-matches-in-tournament/
*/

class Solution {
    public int numberOfMatches(int n) {
        int answer = 0;
        while (n > 1) {
            int half = n / 2;
            int rest = n % 2;
            n = half + rest;
            answer += half;
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Count of Matches in Tournament.
Memory Usage: 35.7 MB, less than 49.62% of Java online submissions for Count of Matches in Tournament.
*/
