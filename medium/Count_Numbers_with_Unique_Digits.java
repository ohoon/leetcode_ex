/*
357.
Count Numbers with Unique Digits
https://leetcode.com/problems/count-numbers-with-unique-digits/
*/

class Solution {
    private int answer = 0;

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        boolean[] used = new boolean[10];       // 이미 사용한 숫자는 true
        count(n, used, false);
        return answer;
    }

    private void count(int n, boolean[] used, boolean isStart) {
        if (n == 0) {       // n자리 수를 만들면 answer을 증가시키고 종료
            answer++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (used[i]) {  // 사용하지 않은 숫자만 다룸
                continue;
            }

            if (!isStart) { // 아직 가장 큰 자리수의 숫자가 정해지지 않았으면
                if (i == 0) {   // leading zero의 경우는 성립X
                    count(n-1, used, isStart);
                    continue;
                } else {        // i = 가장 큰 자리수의 숫자가 되므로 isStart를 true로 전환
                    isStart = true;
                }
            }

            used[i] = true;
            count(n-1, used, isStart);      // backtracking
            used[i] = false;
        }
    }
}

/*
Runtime: 60 ms, faster than 9.25% of Java online submissions for Count Numbers with Unique Digits.
Memory Usage: 37.4 MB, less than 12.99% of Java online submissions for Count Numbers with Unique Digits.
*/
