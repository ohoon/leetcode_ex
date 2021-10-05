/*
2027.
Minimum Moves to Convert String
https://leetcode.com/problems/minimum-moves-to-convert-string/
*/

class Solution {
    public int minimumMoves(String s) {
        int answer = 0;
        int cur = 0;
        while (cur < s.length()) {              // 문자 3개 단위로 탐색, 첫 문자가 X일 경우에만 convert를 해야 최적의 해가 나올 수 있음
            if (s.charAt(cur) == 'O') {         // 첫 문자가 O라면 다음 문자로 이동
                cur++;
                continue;
            }
            
            cur += 3;                           // 첫 문자가 X라면 3개의 문자를 모두 O로 convert하고 3개 다음의 문자로 cur 이동
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 79.64% of Java online submissions for Minimum Moves to Convert String.
Memory Usage: 38.4 MB, less than 78.70% of Java online submissions for Minimum Moves to Convert String.
*/
