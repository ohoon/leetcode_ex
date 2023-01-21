/*
2414.
Length of the Longest Alphabetical Continuous Substring
https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
*/

class Solution {
    public int longestContinuousSubstring(String s) {
        int answer = 0, cur = 0, n = s.length();
        while (cur < n) {
            int len = 0;
            for (char c = s.charAt(cur); c <= 'z'; c = (char) (c+1)) {
                if (cur == n || c != s.charAt(cur)) {
                    break;
                }

                cur++;
                len++;
            }

            answer = Math.max(answer, len);
        }

        return answer;
    }
}
