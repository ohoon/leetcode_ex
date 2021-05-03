/*
1614.
Maximum Nesting Depth of the Parentheses
https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
*/

class Solution {
    public int maxDepth(String s) {
        int answer = 0;
        int depth = 0;          // 현재 깊이
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {       // 열린 괄호의 경우, depth를 증가시키고 answer 갱신
                answer = Math.max(answer, ++depth);
            } else if (s.charAt(i) == ')') {
                depth--;                    // 닫힌 괄호의 경우, depth를 감소
            }
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Nesting Depth of the Parentheses.
Memory Usage: 37.4 MB, less than 15.79% of Java online submissions for Maximum Nesting Depth of the Parentheses.
*/
