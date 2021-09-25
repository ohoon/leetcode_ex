'''
2000.
Reverse Prefix of Word
https://leetcode.com/problems/reverse-prefix-of-word/
'''

class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        boolean isFound = false;
        for (char c : word.toCharArray()) {
            sb.append(c);
            if (!isFound && c == ch) {      // prefix인 c를 찾으면 현재까지의 String을 reverse, 찾은 이후에는 오직 append만 수행
                sb.reverse();
                isFound = true;
            }
        }
        
        return sb.toString();
    }
}

'''
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Prefix of Word.
Memory Usage: 37 MB, less than 95.55% of Java online submissions for Reverse Prefix of Word.
'''
