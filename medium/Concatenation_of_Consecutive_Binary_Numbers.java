/*
1680.
Concatenation of Consecutive Binary Numbers
https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
*/

class Solution {
    private int getBitLength(int n) {       // 십진수 n을 이진수로 변환하였을 때 비트 수를 반환하는 함수
        int res = 1;
        while (n > 1) {
            n /= 2;
            res++;
        }

        return res;
    }

    public int concatenatedBinary(int n) {
        long answer = 0L;
        long limit = (long) Math.pow(10, 9) + 7;
        for (int i = 1; i <= n; i++) {
            answer = ((answer << getBitLength(i)) + i) % limit;     // answer을 i의 비트 수 만큼 왼쪽으로 시프트하고 시프트한 자리에 i가 들어가도록 계산
        }

        return (int) answer;
    }
}

/*
Runtime: 537 ms, faster than 29.48% of Java online submissions for Concatenation of Consecutive Binary Numbers.
Memory Usage: 36.2 MB, less than 52.34% of Java online submissions for Concatenation of Consecutive Binary Numbers.
*/
