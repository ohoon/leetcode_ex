/*
2644.
Find the Maximum Divisibility Score
https://leetcode.com/problems/find-the-maximum-divisibility-score/
*/

class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxIndex = -1, maxScore = 0;
        for (int i = 0; i < divisors.length; i++) {
            int score = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    score++;
                }
            }

            if (score > maxScore || (score == maxScore && (maxIndex == -1 || divisors[i] < divisors[maxIndex]))) {
                maxIndex = i;
                maxScore = score;
            }
        }

        return divisors[maxIndex];
    }
}
