/*
491.
Increasing Subsequences
https://leetcode.com/problems/increasing-subsequences/
*/

class Solution {
    private void backtrack(int[] nums, int index, List<Integer> seq, Set<List<Integer>> total) {
        if (index == nums.length) {
            return;
        }
        
        if (seq.size() > 0 && seq.get(seq.size()-1) > nums[index]) {        // increasing하지 않으면 바로 종료
            return;
        }
        
        seq.add(nums[index]);
        if (seq.size() > 1) {
            total.add(new ArrayList<>(seq));
        }
        
        for (int i = index+1; i < nums.length; i++) {       // seq을 이어갈 다음 요소 선택
            backtrack(nums, i, seq, total);
        }
        
        seq.remove(seq.size()-1);
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();        // sub sequence들의 중복을 없애기 위해 hashset 사용
        for (int i = 0; i < nums.length-1; i++) {
            backtrack(nums, i, new ArrayList<>(), answer);  // backtrack
        }
        
        return new ArrayList<>(answer);
    }
}

/*
Runtime: 20 ms, faster than 46.50% of Java online submissions for Increasing Subsequences.
Memory Usage: 67.8 MB, less than 61.92% of Java online submissions for Increasing Subsequences.
*/
