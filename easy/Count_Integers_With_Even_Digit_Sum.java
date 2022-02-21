/*
2180.
Count Integers With Even Digit Sum
https://leetcode.com/problems/count-integers-with-even-digit-sum/
*/

class Solution {
    public int countEven(int num) {         // dynamic programming
        int answer = 0;
        int[] digitSum = new int[1001];     // 숫자의 digit sum을 기록하는 memoization용 배열
        for (int i = 1; i <= num; i++) {
            if (digitSum[i/10] > 0) {       // 일의 자리를 제외한 수의 digit sum이 이미 계산되었다면 가져와서 사용
                digitSum[i] = digitSum[i/10] + i % 10;
            } else {
                int n = i, sum = 0;
                while (n > 0) {             // 이미 계산되지 않았다면 각 digit의 합을 계산
                    sum += n % 10;
                    n /= 10;
                }

                digitSum[i] = sum;
            }
            
            if (digitSum[i] % 2 == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 75.00% of Java online submissions for Count Integers With Even Digit Sum.
Memory Usage: 41.9 MB, less than 25.00% of Java online submissions for Count Integers With Even Digit Sum.
*/
