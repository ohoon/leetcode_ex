/*
78.
Subsets
https://leetcode.com/problems/subsets/
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        sub(nums, 0, new ArrayList<Integer>(), answer);
        
        return answer;
    }
    
    private void sub(int[] arr, int i, List<Integer> subset, List<List<Integer>> answer) {
        if (i == arr.length) {
            answer.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(arr[i]);
        sub(arr, i+1, subset, answer);
        subset.remove(subset.size() - 1);
        sub(arr, i+1, subset, answer);
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
Memory Usage: 39.7 MB, less than 21.51% of Java online submissions for Subsets.
*/
