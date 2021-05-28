/*
1800.
Maximum Ascending Subarray Sum
https://leetcode.com/problems/maximum-ascending-subarray-sum/
*/

class Solution {
    public int maxAscendingSum(int[] nums) {
        int answer = nums[0];
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] >= nums[i]) {             // ascending 하지 않으면
                answer = Math.max(answer, total);   // answer 갱신
                total = nums[i];                    // total 새로 초기화
            } else {                                // ascending 하면
                total += nums[i];                   // total에 누적
            }
        }
        
        return Math.max(answer, total);             // 마지막 subarray 계산
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Ascending Subarray Sum.
Memory Usage: 36.8 MB, less than 20.69% of Java online submissions for Maximum Ascending Subarray Sum.
*/
