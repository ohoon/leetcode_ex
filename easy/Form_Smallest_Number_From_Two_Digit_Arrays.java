/*
2605.
Form Smallest Number From Two Digit Arrays
https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/
*/

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        boolean[] n1 = new boolean[10];
        boolean[] n2 = new boolean[10];
        for (int n : nums1) {
            n1[n] = true;
        }

        for (int n : nums2) {
            n2[n] = true;
        }

        int min1 = 10, min2 = 10;
        for (int i = 1; i < 10; i++) {
            if (n1[i] && n2[i]) {
                return i;
            }

            if (n1[i]) {
                min1 = Math.min(min1, i);
            }

            if (n2[i]) {
                min2 = Math.min(min2, i);
            }
        }

        return Math.min(min1, min2) * 10 + Math.max(min1, min2);
    }
}
