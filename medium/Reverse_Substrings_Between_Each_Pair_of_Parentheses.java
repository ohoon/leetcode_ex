/*
1190.
Reverse Substrings Between Each Pair of Parentheses
https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
*/

class Solution {
    private String reverseString(String s) {        // 문자열을 뒤집어서 반환하는 메서드
        return new StringBuilder(s).reverse().toString();
    }
    
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int L = -1, depth = 0;          // L = 첫 괄호가 나온 위치, depth = 현재 괄호 스택 깊이
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' && depth++ == 0) {     // (가 나오면 depth 증가. 증가시키기 전에 depth가 0이었다면 L 위치 설정
                L = i;
            } else if (c == ')' && --depth == 0) {      // )가 나오면 depth 감소. 감소시킨 후에 depth가 0이 되면 L~i까지의 문자열을 순회시킨 후에 결과값을 뒤집어서 stringbuilder에 삽입
                sb.append(reverseString(reverseParentheses(s.substring(L+1, i))));
            } else if (depth == 0) {        // (, )가 아니고 depth가 0인 상태면 문자 그대로 stringbuilder에 삽입
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}

/*
Runtime: 2 ms, faster than 83.56% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
Memory Usage: 41.8 MB, less than 12.02% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
*/
