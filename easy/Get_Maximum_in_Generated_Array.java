/*
1646.
Get Maximum in Generated Array
https://leetcode.com/problems/get-maximum-in-generated-array/
*/

class Solution {
    public int getMaximumGenerated(int n) {
        int[] nums = new int[n+1];
        int answer = 0;
        if (n < 2) {
            return n;
        }

        nums[1] = 1;
        for (int i = 0; i < n + 1; i++) {
            if (i % 2 == 0) {           // 짝수인 경우
                nums[i] = nums[i/2];
            } else {                    // 홀수인 경우
                nums[i] = nums[i/2] + nums[i/2+1];
            }

            answer = Math.max(nums[i], answer);     // 최댓값 갱신
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Get Maximum in Generated Array.
Memory Usage: 35.5 MB, less than 82.23% of Java online submissions for Get Maximum in Generated Array.
*/
