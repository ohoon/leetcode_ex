/*
1281.
Subtract the Product and Sum of Digits of an Integer
https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
*/

class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;                // 곱 연산 결과
        int sum = 0;                    // 합 연산 결과
        while (n > 0) {
            int digit = n % 10;         // 한 자리씩 검사
            product *= digit;
            sum += digit;
            n /= 10;                    // 다음 자리로
        }
        return product - sum;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
Memory Usage: 35.7 MB, less than 67.75% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
*/
