/*
2748.
Number of Beautiful Pairs
https://leetcode.com/problems/number-of-beautiful-pairs/
*/

class Solution {

    public int gcd(int x, int y) {
        x = String.valueOf(x).charAt(0) - '0';
        y %= 10;
        for (int i = Math.min(x, y); i >= 1; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }

        return 1;
    }

    public int countBeautifulPairs(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (gcd(nums[i], nums[j]) == 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
