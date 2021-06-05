/*
1844.
Replace All Digits with Characters
https://leetcode.com/problems/replace-all-digits-with-characters/
*/

class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                sb.append((char) (s.charAt(i-1) + s.charAt(i) - '0'));          // 홀수번째인 경우, 바로 앞의 알파벳 + 현재 정수 오프셋
            } else {
                sb.append(s.charAt(i));                                         // 짝수번째인 경우, 알파벳 그대로
            }
        }
        
        return sb.toString();
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Replace All Digits with Characters.
Memory Usage: 37.2 MB, less than 74.40% of Java online submissions for Replace All Digits with Characters.
*/
