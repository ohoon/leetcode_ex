/*
2160.
Minimum Sum of Four Digit Number After Splitting Digits
https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
*/

class Solution {
    public int minimumSum(int num) {
        int answer = 0;
        int first = 9, second = 9;      // 1, 2번째로 작은 수
        while (num > 0) {
            int digit = num % 10;
            answer += digit;            // 각 자리수를 모두 더해줌
            num /= 10;
            if (digit < first) {        // first, second 갱신
                second = first;
                first = digit;
            } else if (digit < second) {
                second = digit;
            }
        }
        
        answer += 9 * (first + second);     // 최소합이 나오기 위해서는 두 수의 십의 자리가 1, 2번째로 작은 수여야 함
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Sum of Four Digit Number After Splitting Digits.
Memory Usage: 40.4 MB, less than 16.67% of Java online submissions for Minimum Sum of Four Digit Number After Splitting Digits.
*/
