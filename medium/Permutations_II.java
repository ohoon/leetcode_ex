/*
47.
Permutations II
https://leetcode.com/problems/permutations-ii/
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        sub(nums, used, new ArrayList<>(), answer);
        return answer;
    }
    
    private void sub(int[] nums, boolean[] used, List<Integer> p, List<List<Integer>> answer) {
        if (p.size() == nums.length) {
            answer.add(new ArrayList<>(p));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !used[i-1] && nums[i-1] == nums[i]) {
                continue;
            }
            
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                sub(nums, used, p, answer);
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }
}

/*
Runtime: 1 ms, faster than 99.32% of Java online submissions for Permutations II.
Memory Usage: 39.8 MB, less than 50.88% of Java online submissions for Permutations II.
*/
