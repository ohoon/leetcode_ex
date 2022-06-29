/*
991.
Broken Calculator
https://leetcode.com/problems/broken-calculator/
*/

class Solution {
    public int brokenCalc(int startValue, int target) {
        int answer = 0;
        while (target > startValue) {   // 빼기 연산보다 곱셉 연산이 무조건 효율이 좋음
            answer++;
            if (target % 2 == 1) {      // target이 홀수라면 덧셈 우선
                target++;
            } else {                    // 짝수라면 나누기 우선
                target /= 2;
            }
        }
        
        return answer + startValue - target;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Broken Calculator.
Memory Usage: 41.3 MB, less than 18.57% of Java online submissions for Broken Calculator.
*/
