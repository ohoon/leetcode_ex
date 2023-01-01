/*
2520.
Count the Digits That Divide a Number
https://leetcode.com/problems/count-the-digits-that-divide-a-number/
*/

class Solution {
    public int countDigits(int num) {
        int answer = 0, num2 = num;
        while (num2 > 0) {
            if (num % (num2 % 10) == 0) {
                answer++;
            }

            num2 /= 10;
        }

        return answer;
    }
}
