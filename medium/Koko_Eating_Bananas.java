/*
875.
Koko Eating Bananas
https://leetcode.com/problems/koko-eating-bananas/
*/

class Solution {
    private boolean eating(int speed, int[] piles, int h) {     // 이진 탐색
        for (int p : piles) {
            h -= (int) Math.ceil((double) p / speed);
            if (h < 0) {
                return false;
            }
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int L = 1, R = piles[piles.length-1];
        while (L < R) {
            int m = (L + R) / 2;
            if (eating(m, piles, h)) {
                R = m;
            } else {
                L = m + 1;
            }
        }

        return L;
    }
}
