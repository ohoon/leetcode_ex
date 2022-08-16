/*
921.
Minimum Add to Make Parentheses Valid
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
*/

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                continue;
            }
            
            if (open > 0) {     // 이전에 열린 괄호가 있으면 정상적으로 닫음
                open--;
                continue;
            }
            
            close++;            // 이전에 열린 괄호가 없으면 parentheses한 괄호이므로 카운팅
        }
        
        return open + close;        // 미처 닫히지 않은 열린 괄호 개수 + parentheses한 괄호 개수
    }
}

/*
Runtime: 1 ms, faster than 90.28% of Java online submissions for Minimum Add to Make Parentheses Valid.
Memory Usage: 41.9 MB, less than 60.27% of Java online submissions for Minimum Add to Make Parentheses Valid.
*/
