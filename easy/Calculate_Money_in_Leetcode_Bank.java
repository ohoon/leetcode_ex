/*
1716.
Calculate Money in Leetcode Bank
https://leetcode.com/problems/calculate-money-in-leetcode-bank/
*/

class Solution {
    public int totalMoney(int n) {
        int week = n / 7;       // 이미 지난 주
        int answer = 28 * week + (7 * week * (week - 1) / 2);       // 지난 주의 경우 1~7의 합 + 주 별로 추가되는 offset의 합
        for (int i = 1; i <= n % 7; i++) {          // 나머지 일 수 처리
            answer += week + i;
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Calculate Money in Leetcode Bank.
Memory Usage: 35.5 MB, less than 88.26% of Java online submissions for Calculate Money in Leetcode Bank.
*/
