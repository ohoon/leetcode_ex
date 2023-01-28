/*
90.
Subsets II
https://leetcode.com/problems/subsets-ii/
*/

class Solution {
    private void backtrack(int[] nums, int index, List<Integer> list, Set<List<Integer>> set) {
        for (int i = index+1; i < nums.length; i++) {
            backtrack(nums, i, new ArrayList<>(list), set);     // 현재 요소를 넣기 전과 넣기 후로 분기하여 순회
            list.add(nums[i]);
            backtrack(nums, i, new ArrayList<>(list), set);
        }

        if (index == nums.length - 1) {
            set.add(new ArrayList<>(list));
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        backtrack(nums, -1, new ArrayList<>(), answer);
        return new ArrayList<>(answer);
    }
}
