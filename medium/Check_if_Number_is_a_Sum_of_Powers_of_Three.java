/*
1780.
Check if Number is a Sum of Powers of Three
https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
*/

class Solution {
    public boolean checkPowersOfThree(int n) {
        if (n == 1) {       // 재귀 종료 부분
            return true;
        }
        
        if (n % 3 == 0) {   // 3으로 나누어 떨어지면 n/3으로 재귀
            return checkPowersOfThree(n/3);
        }
        
        if ((n-1) % 3 == 0) {   // 3의 0승인 1을 제외하고 다시 3으로 나누어 떨어지는지 검사
            return checkPowersOfThree((n-1)/3);
        }
        
        return false;       // 3의 n승으로 구성할 수 없는 수이므로 false 반환
    }
}

/*
Runtime: 1 ms, faster than 37.50% of Java online submissions for Check if Number is a Sum of Powers of Three.
Memory Usage: 41.5 MB, less than 20.35% of Java online submissions for Check if Number is a Sum of Powers of Three.
*/
