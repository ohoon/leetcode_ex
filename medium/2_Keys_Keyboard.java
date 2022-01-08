/*
650.
2 Keys Keyboard
https://leetcode.com/problems/2-keys-keyboard/
*/

class Solution {
    public int minSteps(int n) {
        if (n == 1) {       // 시작지점(n = 1)으로 오면 0을 반환하고 재귀 종료
            return 0;
        }
        
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {     // n의 약수인 i를 찾은 후, n/i를 copy(1번)해서 paste(i-1번)하는 원리를 이용
            if (n % i == 0) {
                return i + minSteps(n/i);
            }
        }
        
        return n;       // n이 prime이라면 n번 step을 거침
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for 2 Keys Keyboard.
Memory Usage: 37.9 MB, less than 27.39% of Java online submissions for 2 Keys Keyboard.
*/
