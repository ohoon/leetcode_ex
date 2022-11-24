/*
1749.
Maximum Absolute Sum of Any Subarray
https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
*/

class Solution {
    public int maxAbsoluteSum(int[] nums) {     // sliding window
        int answer = 0;
        int pos = 0, neg = 0;
        for (int n : nums) {
            pos = (n + pos) >= 0 ? pos + n : 0;       // n이 pos의 값을 음수로 만들면 0으로 초기화
            neg = (n + neg) < 0 ? neg + n : 0;       // n이 neg의 값을 양수로 만들면 0으로 초기화
            answer = Math.max(answer, Math.max(pos, -neg));
        }

        return answer;
    }
}
