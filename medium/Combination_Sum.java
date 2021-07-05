/*
39.
Combination Sum
https://leetcode.com/problems/combination-sum/
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        sub(candidates, 0, target, answer, new ArrayList());
        return answer;
    }
    
    public void sub(int[] candidates, int start, int target, List<List<Integer>> answer, List<Integer> result) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            answer.add(new ArrayList(result));
        }
        
        for(int i = start; i < candidates.length; i++) {
            result.add(candidates[i]);
            sub(candidates, i, target - candidates[i], answer, result);
            result.remove(result.size() - 1);
        }
    }
}

/*
Runtime: 4 ms, faster than 52.41% of Java online submissions for Combination Sum.
Memory Usage: 39.2 MB, less than 69.47% of Java online submissions for Combination Sum.
*/
