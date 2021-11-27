/*
856.
Score of Parentheses
https://leetcode.com/problems/score-of-parentheses/
*/

class Solution {
    public int scoreOfParentheses(String s) {
        int answer = 0, depth = 0;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if (curr == '(') {      // 열린 괄호가 오는 경우는 depth만 증가
                depth++;
                continue;
            }

            if (prev == '(') {      // 닫힌 괄호가 오고 바로 전의 문자가 '('인 경우 ('()' 모양) 2의 depth승하여 answer에 추가
                answer += Math.pow(2, depth--);
                continue;
            }

            depth--;                // 일반적인 닫힌 괄호일 경우 depth만 감소
        }

        return answer;
    }
}

/*
Runtime: 1 ms, faster than 42.00% of Java online submissions for Score of Parentheses.
Memory Usage: 38.3 MB, less than 36.38% of Java online submissions for Score of Parentheses.
*/
