/*
1052.
Grumpy Bookstore Owner
https://leetcode.com/problems/grumpy-bookstore-owner/
*/

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {       // sliding window
        int count = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 0) {
                continue;
            }

            count += customers[i];
        }

        int max = count;
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                count += customers[i];
            }

            if (grumpy[i-minutes] == 1) {
                count -= customers[i-minutes];
            }

            max = Math.max(max, count);
        }

        int answer = max;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                continue;
            }

            answer += customers[i];
        }

        return answer;
    }
}
