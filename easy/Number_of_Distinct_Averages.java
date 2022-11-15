/*
2465.
Number of Distinct Averages
https://leetcode.com/problems/number-of-distinct-averages/
*/

class Solution {
    public int distinctAverages(int[] nums) {       // sort
        Set<Double> set = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n/2; i++) {
            set.add((nums[i]+nums[n-i-1]) / 2.0);
        }

        return set.size();
    }
}
