/*
209.
Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE, sum = 0;
        int n = nums.length;
        int L = 0;
        for (int R = 0; R < n; R++) {           // two pointer
            sum += nums[R];                     // sum이 target이상이 될때까지 R포인터를 하나씩 늘림
            if (sum < target) {
                continue;
            }
            
            while (sum - nums[L] >= target) {       // sum이 target 이상이어야 하는 조건 하에 L포인터를 하나씩 올림
                sum -= nums[L++];
            }
            
            answer = Math.min(answer, R-L+1);       // 최적화된 size로 answer 갱신
        }
        
        return answer != Integer.MAX_VALUE ? answer : 0;
    }
}

/*
Runtime: 1 ms, faster than 99.95% of Java online submissions for Minimum Size Subarray Sum.
Memory Usage: 38.9 MB, less than 78.42% of Java online submissions for Minimum Size Subarray Sum.
*/
