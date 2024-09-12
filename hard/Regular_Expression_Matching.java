/*
10.
Regular Expression Matching
https://leetcode.com/problems/regular-expression-matching/
*/

class Solution {
    public boolean backtrack(String s, int si, String p, int pi) {
        if (si >= s.length() && pi >= p.length()) {
            return true;
        }

        if (pi >= p.length()) {
            return false;
        }

        if (pi+1 < p.length() && p.charAt(pi+1) == '*') {
            if (p.charAt(pi) == '.') {
                if (si >= s.length()) {
                    return backtrack(s, si, p, pi+2);
                }

                return backtrack(s, si+1, p, pi) || backtrack(s, si, p, pi+2);
            }

            if (si < s.length() && s.charAt(si) == p.charAt(pi)) {
                return backtrack(s, si+1, p, pi) || backtrack(s, si, p, pi+2);
            }

            return backtrack(s, si, p, pi+2);
        }

        if (si < s.length() && p.charAt(pi) == '.') {
            return backtrack(s, si+1, p, pi+1);
        }

        if (si >= s.length() || s.charAt(si) != p.charAt(pi)) {
            return false;
        }

        return backtrack(s, si+1, p, pi+1);
    }

    public boolean isMatch(String s, String p) {
        return backtrack(s, 0, p, 0);
    }
}

/*
Runtime 491ms Beats 13.89%
Memory 41.50MB Beats 98.88%

코드가 알기 어렵고 최적화가 제대로 되지 않아 만족스러운 결과는 아님
*/
