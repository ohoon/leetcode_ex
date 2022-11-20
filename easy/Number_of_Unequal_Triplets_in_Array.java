/*
2475.
Number of Unequal Triplets in Array
https://leetcode.com/problems/number-of-unequal-triplets-in-array/
*/

class Solution {
    public int unequalTriplets(int[] nums) {
        int answer = 0, n = nums.length;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (nums[i] == nums[j] || nums[j] == nums[k] || nums[k] == nums[i]) {
                        continue;
                    }

                    answer++;
                }
            }
        }

        return answer;
    }
}
