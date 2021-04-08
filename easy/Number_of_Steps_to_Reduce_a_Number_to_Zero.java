/*
1342.
Number of Steps to Reduce a Number to Zero
https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
*/

class Solution {
    public int numberOfSteps(int num) {
        int answer = 0;
        while (num > 0) {           // 0이 될 때까지
            if (num % 2 == 0) {     // 짝수면 2로 나눈 몫을
                num /= 2;
            } else {                // 홀수면 1을 뺀 값을
                num -= 1;
            }
            
            answer++;               // while 반복마다 answer 증가
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
Memory Usage: 35.9 MB, less than 40.67% of Java online submissions for Number of Steps to Reduce a Number to Zero.
*/
