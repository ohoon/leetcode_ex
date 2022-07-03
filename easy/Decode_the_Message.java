/*
2325.
Decode the Message
https://leetcode.com/problems/decode-the-message/
*/

class Solution {
    public String decodeMessage(String key, String message) {
        char[] table = new char[26];        // 매핑 테이블
        char ch = 'a';
        for (char c : key.toCharArray()) {
            if (c == ' ' || table[c-'a'] != '\u0000') {     // 이미 매핑된 알파벳이거나 띄어쓰기인 경우에는 패스
                continue;
            }
            
            table[c-'a'] = ch++;        // a부터 차례대로 매핑
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {     // 띄어쓰기는 매핑하지 않음
                sb.append(c);
                continue;
            }
            
            sb.append(table[c-'a']);
        }
        
        return sb.toString();
    }
}

/*
Runtime: 3 ms, faster than 71.43% of Java online submissions for Decode the Message.
Memory Usage: 42.5 MB, less than 57.14% of Java online submissions for Decode the Message.
*/
