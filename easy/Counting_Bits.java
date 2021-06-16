/*
338.
Counting Bits
https://leetcode.com/problems/counting-bits/
*/

class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            answer[i] += answer[i/2] + i % 2;           // 오른쪽 시프트 1한 결과를 앞의 결과에서 가져오고 마지막 비트만 계산 ex) 1101 -> 110의 1 개수 + 마지막 비트 검증
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 99.94% of Java online submissions for Counting Bits.
Memory Usage: 42.8 MB, less than 92.01% of Java online submissions for Counting Bits.
*/
