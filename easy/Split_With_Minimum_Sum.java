/*
2578.
Split With Minimum Sum
https://leetcode.com/problems/split-with-minimum-sum/
*/

class Solution {
    public int splitNum(int num) {      // greedy
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }

        int num1 = 0, num2 = 0;
        boolean swt = true;     // swt가 true면 num1를 증가, false면 num2를 증가시킴
        for (int i = 0; i < 10; i++) {
            while (freq[i] > 0) {
                if (freq[i] == 1) {
                    if (swt) {
                        num1 = num1 * 10 + i;
                    } else {
                        num2 = num2 * 10 + i;
                    }

                    swt = !swt;
                    freq[i]--;
                    break;
                }

                num1 = num1 * 10 + i;
                num2 = num2 * 10 + i;
                freq[i] -= 2;
            }
        }

        return num1 + num2;
    }
}
