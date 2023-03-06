/*
2582.
Pass the Pillow
https://leetcode.com/problems/pass-the-pillow/
*/

class Solution {
    public int passThePillow(int n, int time) {
        int cycle = 2*n - 2;
        time %= cycle;
        return time < cycle / 2 ? time + 1 : n - (time - cycle / 2);
    }
}
