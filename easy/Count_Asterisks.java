/*
2315.
Count Asterisks
https://leetcode.com/problems/count-asterisks/
*/

class Solution {
    public int countAsterisks(String s) {
        int answer = 0;
        boolean isInBar = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {       // '|'를 만나면 isInBar 상태 변경
                isInBar = !isInBar;
                continue;
            }
            
            if (isInBar) {      // '|' 안에 있는 경우 카운팅 생략
                continue;
            }
            
            if (s.charAt(i) == '*') {
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 14.29% of Java online submissions for Count Asterisks.
Memory Usage: 40.1 MB, less than 100.00% of Java online submissions for Count Asterisks.
*/
