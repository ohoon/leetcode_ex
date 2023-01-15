/*
2535.
Difference Between Element Sum and Digit Sum of an Array
https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
*/

class Solution {
    public int differenceOfSum(int[] nums) {
        int elemSum = 0, digitSum = 0;
        for (int num : nums) {
            elemSum += num;
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }

        return Math.abs(elemSum - digitSum);
    }
}
