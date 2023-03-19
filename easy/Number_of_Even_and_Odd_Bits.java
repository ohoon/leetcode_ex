/*
2595.
Number of Even and Odd Bits
https://leetcode.com/problems/number-of-even-and-odd-bits/
*/

class Solution {
    public int[] evenOddBit(int n) {
        int[] answer = new int[2];
        boolean isEven = true;
        while (n > 0) {
            if (n % 2 == 1) {
                if (isEven) {
                    answer[0]++;
                } else {
                    answer[1]++;
                }
            }

            isEven = !isEven;
            n /= 2;
        }

        return answer;
    }
}
