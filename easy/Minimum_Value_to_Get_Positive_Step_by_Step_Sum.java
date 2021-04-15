/*
1413.
Minimum Value to Get Positive Step by Step Sum
https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
*/

class Solution {
    public int minStartValue(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {     // Dynamic Programming
            nums[i] += nums[i-1];
            if (nums[i] < min) {                    // 최솟값 갱신
                min = nums[i];
            }
        }
        
        return (min < 1) ? (1 - min) : 1;           // min이 0이하면 1을 만들기 위한 수를 반환 아니면 최소 possitive value 1 반환
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
Memory Usage: 36.2 MB, less than 71.90% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
*/
