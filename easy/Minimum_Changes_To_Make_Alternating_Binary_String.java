/*
1758.
Minimum Changes To Make Alternating Binary String
https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
*/

class Solution {
    public int minOperations(String s) {
        int startZero = 0;          // s = "0101..."
        int startOne = 0;           // s = "1010..."
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i % 2 == 0) {
                    startOne++;
                } else {
                    startZero++;
                }
            } else {
                if (i % 2 == 0) {
                    startZero++;
                } else {
                    startOne++;
                }
            }
        }

        return Math.min(startZero, startOne);
    }
}

/*
Runtime: 3 ms, faster than 68.38% of Java online submissions for Minimum Changes To Make Alternating Binary String.
Memory Usage: 38.8 MB, less than 68.13% of Java online submissions for Minimum Changes To Make Alternating Binary String.
*/

/*
여담

문제를 너무 어렵게 생각한 것 같다.
다음에 다시 제대로 풀어보자.

 */