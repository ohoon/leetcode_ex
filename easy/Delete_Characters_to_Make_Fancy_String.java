'''
1957.
Delete Characters to Make Fancy String
https://leetcode.com/problems/delete-characters-to-make-fancy-string/
'''

class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < 2 || s.charAt(i-2) != s.charAt(i-1) || s.charAt(i-1) != s.charAt(i)) {      // 연속된 세 문자가 같으면 stringbuilder에 삽입되지 않음
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}

'''
Runtime: 44 ms, faster than 56.99% of Java online submissions for Delete Characters to Make Fancy String.
Memory Usage: 39.8 MB, less than 94.74% of Java online submissions for Delete Characters to Make Fancy String.
'''
