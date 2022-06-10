/*
1658.
Minimum Operations to Reduce X to Zero
https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
*/

class Solution {
    public int minOperations(int[] nums, int x) {       // sliding window
        int answer = Integer.MAX_VALUE;
        int sum = Arrays.stream(nums).sum();
        int L = 0, R = 0, n = nums.length;
        if (sum == x) {     // nums를 모두 써야 x를 만들 수 있을 때
            return n;
        }
        
        sum -= nums[0];
        while (L < n) {
            if (L > R) {            // L포인터가 R포인터를 넘었을 때 -> L포인터에서 새롭게 window를 만들기 시작함
                R = L;
                sum -= nums[R];
            }
            
            if (sum == x) {
                answer = Math.min(answer, L + n-R-1);
            }
            
            if (sum <= x) {         // window 합이 x 이상이 되면 window 폭을 줄임
                sum += nums[L++];
                continue;
            }
            
            if (R == n-1) {
                break;
            }
            
            sum -= nums[++R];       // window 합이 x 미만이 되면 window 폭을 늘림
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}

/*
Runtime: 14 ms, faster than 52.07% of Java online submissions for Minimum Operations to Reduce X to Zero.
Memory Usage: 96.3 MB, less than 49.31% of Java online submissions for Minimum Operations to Reduce X to Zero.
*/
