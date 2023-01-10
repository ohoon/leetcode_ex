/*
2525.
Categorize Box According to Criteria
https://leetcode.com/problems/categorize-box-according-to-criteria/
*/

class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = length;
        volume *= width;
        volume *= height;
        if (length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000) {
            return mass >= 100 ? "Both" : "Bulky";
        }

        if (mass >= 100) {
            return "Heavy";
        }

        return "Neither";
    }
}
