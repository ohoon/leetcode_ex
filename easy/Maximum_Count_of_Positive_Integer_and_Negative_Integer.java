/*
2529.
Maximum Count of Positive Integer and Negative Integer
https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
*/

class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }

            if (num > 0) {
                pos++;
            } else {
                neg++;
            }
        }

        return Math.max(pos, neg);
    }
}
