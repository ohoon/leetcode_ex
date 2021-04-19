/*
1446.
Consecutive Characters
https://leetcode.com/problems/consecutive-characters/
*/

class Solution {
    public int maxPower(String s) {
        int answer = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {         // 다른 수가 나오면 count의 최대값을 answer에 입력
                answer = Math.max(count, answer);
                count = 1;
            } else {                                    // 같은 수의 연속이면 count 증가
                count++;
            }
        }
        
        return Math.max(count, answer);
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Consecutive Characters.
Memory Usage: 37.4 MB, less than 71.64% of Java online submissions for Consecutive Characters.
*/
