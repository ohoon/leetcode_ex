/*
1513.
Number of Substrings With Only 1s
https://leetcode.com/problems/number-of-substrings-with-only-1s/
*/

class Solution {
    public int numSub(String s) {
        long answer = 0, seq = 0;
        long limit = 1000000007;
        for (char c : s.toCharArray()) {
            if (c == '0') {         // 0이 나오면 seq 초기화
                seq = 0;
                continue;
            }
            
            answer += ++seq;        // 1이 연속해서 나온 만큼 answer에 더해줌 ("1" = 1, "11" = 1+2, "111" = 1+2+3)
            answer %= limit;
            seq %= limit;
        }
        
        return (int) answer;
    }
}

/*
Runtime: 13 ms, faster than 7.24% of Java online submissions for Number of Substrings With Only 1s.
Memory Usage: 43.6 MB, less than 5.86% of Java online submissions for Number of Substrings With Only 1s.
*/
