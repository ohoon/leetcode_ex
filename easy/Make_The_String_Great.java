/*
1544.
Make The String Great
https://leetcode.com/problems/make-the-string-great/
*/

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90) {
                if (!stack.empty() && Character.toLowerCase(c) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                if (!stack.empty() && Character.toUpperCase(c) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}

/*
Runtime: 3 ms, faster than 44.85% of Java online submissions for Make The String Great.
Memory Usage: 39.3 MB, less than 15.96% of Java online submissions for Make The String Great.
*/

/*
다른 사람의 풀이

class Solution {
    public String makeGood(String s) {
        int n = s.length();
        
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i+1)) == 32) {
                return makeGood(s.substring(0, i) + s.substring(i+2));
            }
        }
        
        return s;
    }
}

재귀적으로 풀이한 코드다.
확실히 재귀적으로 푸니까 이해하기도 쉽고 코드도 간단한 것 같다.

*/
