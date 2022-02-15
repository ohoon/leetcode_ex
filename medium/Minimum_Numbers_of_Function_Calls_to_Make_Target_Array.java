/*
1558.
Minimum Numbers of Function Calls to Make Target Array
https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
*/

class Solution {
    public int minOperations(int[] nums) {
        int answer = 0;
        boolean isAllZero = false;      // 모든 요소가 0인지 아닌지 판단하기 위한 불린값
        while (!isAllZero) {
            isAllZero = true;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 > 0) {      // 홀수면 -1
                    nums[i]--;
                    answer++;
                }
                
                if (nums[i] == 0) {         // 0인 요소는 2로 나누지 않고 패스
                    continue;
                }
                
                nums[i] /= 2;               // 하나라도 나누기 2를 거치면 최소 1이므로 모두 0이라는 조건을 성립하지 않음
                isAllZero = false;
            }
            
            if (!isAllZero) {       // 나누기를 거치면 answer 값 하나 증가
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 70 ms, faster than 42.74% of Java online submissions for Minimum Numbers of Function Calls to Make Target Array.
Memory Usage: 55.5 MB, less than 22.58% of Java online submissions for Minimum Numbers of Function Calls to Make Target Array.
*/
