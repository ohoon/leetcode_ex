/*
50.
Pow(x, n)
https://leetcode.com/problems/powx-n/
*/

class Solution {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {                   // overflow가 발생할 수 있는 값 처리
            x = 1 / x;
            n = Integer.MAX_VALUE;
            return x * x * myPow(x*x, (n-1)/2);
        }

        if (n < 0) {                                    // -2승과 같이 n이 음수일 때는 x를 역수로 변환해서 처리
            x = 1 / x;
            n = -n;
        }

        if (n == 0) {
            return 1L;
        }

        if (n % 2 > 0) {                                // myPow를 2번 부르는 것이 아니라 x를 제곱
            return x * myPow(x*x, (n-1)/2);
        } else {
            return myPow(x*x, n/2);
        }
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
Memory Usage: 38.2 MB, less than 67.04% of Java online submissions for Pow(x, n).
*/

/*
여담

쉬운 문제에 속하지만 overflow나 stack이 넘치는 문제가 발생할 수 있는 부분이 많아서
세심하게 코드를 짜는 것이 필요했다.
무식하게 순회를 돌리는 것이 아니라 순회가 필요없는 부분은 따로 순회를 돌리지 않고,
overflow가 발생할 수 있는 부분은 임의적으로 설정하는 것으로 오류를 예방했다.
이 해결 과정에서 다른 풀이들을 많이 참고했으므로 내 것으로 만들기 위해서 다시 풀어보는 시간을 가져야겠다.

 */