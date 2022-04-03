/*
2220.
Minimum Bit Flips to Convert Number
https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
*/

class Solution {
    public int minBitFlips(int start, int goal) {
        int answer = 0;
        while (start > 0 || goal > 0) {
            if (start % 2 != goal % 2) {        // 현재 bit가 다르면 한쪽을 flip
                answer++;
            }
            
            start >>= 1;        // 비트 자리를 왼쪽으로 이동 (위 if절에서 체크한 비트를 버림)
            goal >>= 1;
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 66.67% of Java online submissions for Minimum Bit Flips to Convert Number.
Memory Usage: 41 MB, less than 66.67% of Java online submissions for Minimum Bit Flips to Convert Number.
*/
