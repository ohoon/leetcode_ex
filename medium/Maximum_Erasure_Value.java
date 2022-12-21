/*
1695.
Maximum Erasure Value
https://leetcode.com/problems/maximum-erasure-value/
*/

class Solution {
    public int maximumUniqueSubarray(int[] nums) {          // sliding window
        int answer = 0, sum = 0, n = nums.length;
        int L = 0, R = 0;
        Set<Integer> set = new HashSet<>();     // 중복 관리
        while (R < n) {
            if (set.contains(nums[R])) {        // 현재 윈도우에 같은 값이 존재하면 L포인터 증가
                sum -= nums[L];
                set.remove(nums[L]);
                L++;
                continue;
            }

            sum += nums[R];
            set.add(nums[R]);
            R++;
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
