/*
1221.
Split a String in Balanced Strings
https://leetcode.com/problems/split-a-string-in-balanced-strings/
*/

class Solution {
    public int balancedStringSplit(String s) {
        int R = 0, L = 0;
        int answer = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {     // 각 R, L에 대해 개수를 카운팅
                R++;
            } else {
                L++;
            }
            
            if (R == L) {       // R와 L의 개수가 같을때마다 answer++
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
Memory Usage: 36.8 MB, less than 67.45% of Java online submissions for Split a String in Balanced Strings.
*/
