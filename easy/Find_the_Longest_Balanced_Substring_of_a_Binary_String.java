/*
2609.
Find the Longest Balanced Substring of a Binary String
https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/
*/

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int answer = 0, len = 0, cntZero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                if (len > 0) {
                    len = 0;
                    cntZero = 0;
                }

                cntZero++;
                continue;
            }

            if (cntZero == 0) {
                continue;
            }

            cntZero--;
            len += 2;
            answer = Math.max(answer, len);
        }

        return answer;
    }
}