/*
2544.
Alternating Digit Sum
https://leetcode.com/problems/alternating-digit-sum/
*/

class Solution {
    public int alternateDigitSum(int n) {
        int answer = 0;
        boolean isPositive = true;
        while (n > 0) {
            int digit = n % 10;
            answer = answer + (isPositive ? digit : -digit);
            isPositive = !isPositive;
            n /= 10;
        }

        return isPositive ? -answer : answer;
    }
}
