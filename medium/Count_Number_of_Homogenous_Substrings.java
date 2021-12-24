/*
1759.
Count Number of Homogenous Substrings
https://leetcode.com/problems/count-number-of-homogenous-substrings/
*/

class Solution {
    public int countHomogenous(String s) {
        int answer = 0;
        int repeat = 1;     // 현재 같은 알파벳을 몇번 반복중인지
        char prev = ' ';    // 이전 알파벳
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != prev) {        // 반복이 끝나면 repeat 1로 초기화
                repeat = 1;
            }

            answer = (answer + repeat++) % 1000000007;  // 반복한 횟수만큼 answer에 더해줌 ex) aaa -> a + aa + aaa
            prev = c;
        }

        return answer;
    }
}

/*
Runtime: 10 ms, faster than 82.33% of Java online submissions for Count Number of Homogenous Substrings.
Memory Usage: 39.3 MB, less than 79.86% of Java online submissions for Count Number of Homogenous Substrings.
*/
