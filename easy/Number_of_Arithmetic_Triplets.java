/*
2367.
Number of Arithmetic Triplets
https://leetcode.com/problems/number-of-arithmetic-triplets/
*/

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] exist = new boolean[301];
        for (int n : nums) {
            exist[n] = true;
        }
        
        int answer = 0;
        for (int n : nums) {
            if (!exist[n+diff] || !exist[n+2*diff]) {
                continue;
            }
            
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 75.00% of Java online submissions for Number of Arithmetic Triplets.
Memory Usage: 42 MB, less than 50.00% of Java online submissions for Number of Arithmetic Triplets.
*/
