/*
2670.
Find the Distinct Difference Array
https://leetcode.com/problems/find-the-distinct-difference-array/
*/

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] suffix = new int[nums.length];
        Set<Integer> set = new HashSet<>();
        for (int i = suffix.length-1; i >= 0; i--) {
            suffix[i] = set.size();
            set.add(nums[i]);
        }

        int[] answer = new int[nums.length];
        set.clear();
        for (int i = 0; i < answer.length; i++) {
            set.add(nums[i]);
            answer[i] = set.size() - suffix[i];
        }

        return answer;
    }
}
