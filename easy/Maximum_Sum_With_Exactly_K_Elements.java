/*
2656.
Maximum Sum With Exactly K Elements
https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/
*/

class Solution {
    public int maximizeSum(int[] nums, int k) {
        int answer = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        for (int i = 0; i < k; i++) {
            answer += max + i;
        }

        return answer;
    }
}
