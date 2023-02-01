/*
1503.
Last Moment Before All Ants Fall Out of a Plank
https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
*/

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lenL = left.length, lenR = right.length;
        Arrays.sort(left);
        Arrays.sort(right);
        if (lenL == 0) {
            return n - right[0];
        }

        if (lenR == 0) {
            return left[lenL-1];
        }

        return Math.max(left[lenL-1], n - right[0]);
    }
}
