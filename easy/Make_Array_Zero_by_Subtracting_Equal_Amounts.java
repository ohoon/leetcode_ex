/*
2357.
Make Array Zero by Subtracting Equal Amounts
https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
*/

class Solution {
    public int minimumOperations(int[] nums) {      // greedy
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (n == 0) {
                continue;
            }
            
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        return map.keySet().size();
    }
}

/*
Runtime: 3 ms, faster than 37.50% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.
Memory Usage: 41.3 MB, less than 87.50% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.
*/
