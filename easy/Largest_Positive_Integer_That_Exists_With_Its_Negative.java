/*
2441.
Largest Positive Integer That Exists With Its Negative
https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
*/

class Solution {
    public int findMaxK(int[] nums) {
        int answer = -1;
        boolean[] pos = new boolean[1001];      // 양수 체크용
        boolean[] neg = new boolean[1001];      // 음수 체크용
        for (int num : nums) {
            if (num >= 0) {
                pos[num] = true;
                if (neg[num]) {     // +-num이 존재한다면
                    answer = Math.max(answer, num);
                    continue;
                }
            } else {
                neg[-num] = true;
                if (pos[-num]) {     // +-num이 존재한다면
                    answer = Math.max(answer, -num);
                    continue;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Largest Positive Integer That Exists With Its Negative.
Memory Usage: 42.4 MB, less than 60.00% of Java online submissions for Largest Positive Integer That Exists With Its Negative.
*/
