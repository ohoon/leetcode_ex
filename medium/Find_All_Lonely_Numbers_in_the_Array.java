/*
2150.
Find All Lonely Numbers in the Array
https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
*/

class Solution {
    public List<Integer> findLonely(int[] nums) {       // sorting
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if ((i > 0 && Math.abs(nums[i-1] - nums[i]) <= 1) || (i < n-1 && Math.abs(nums[i] - nums[i+1]) <= 1)) {
                continue;
            }

            answer.add(nums[i]);
        }

        return answer;
    }
}
