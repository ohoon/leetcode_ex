/*
413.
Arithmetic Slices
https://leetcode.com/problems/arithmetic-slices/
*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int answer = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            int gap = nums[i+1] - nums[i];      // 요소 사이의 간격
            for (int j = i+1; j < nums.length - 1; j++) {       // 요소 하나씩 늘려가면서 gap이 일정할 때 까지 answer 증가
                if (nums[j+1] - nums[j] != gap) {
                    break;
                }
                
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Arithmetic Slices.
Memory Usage: 39 MB, less than 7.58% of Java online submissions for Arithmetic Slices.
*/
