/*
2348.
Number of Zero-Filled Subarrays
https://leetcode.com/problems/number-of-zero-filled-subarrays/
*/

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long answer = 0;
        int n = nums.length;
        int prev = -1;      // 0으로 이루어진 subarray의 시작점
        for (int i = 0; i < n; i++) {
            if (prev == -1 && nums[i] == 0) {       // 시작점 저장
                prev = i;
            }

            if (nums[i] == 0 && (i == n-1 || nums[i+1] != 0)) {     // 끝지점에 도달하면
                for (int j = i - prev + 1; j > 0; j--) {        // 경우의수 = 연속한 0의 개수 ~ 1의 합
                    answer += j;
                }
                
                prev = -1;      // 시작점 초기화
            }
        }

        return answer;
    }
}
