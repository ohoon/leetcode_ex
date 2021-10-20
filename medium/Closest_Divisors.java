/*
1362.
Closest Divisors
https://leetcode.com/problems/closest-divisors/
*/

class Solution {
    public int[] closestDivisors(int num) {
        int[] answer = new int[2];
        for (int i = (int) Math.sqrt(num+2); i > 0; i--) {      // num+2의 제곱근부터 시작하여 약수가 되는 i를 탐색
            if ((num + 1) % i == 0) {           // num+1의 약수일 경우
                answer[0] = i;
                answer[1] = (num + 1) / i;
                return answer;
            }
            
            if ((num + 2) % i == 0) {           // num+2의 약수일 경우
                answer[0] = i;
                answer[1] = (num + 2) / i;
                return answer;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 8 ms, faster than 60.58% of Java online submissions for Closest Divisors.
Memory Usage: 38.6 MB, less than 10.58% of Java online submissions for Closest Divisors.
*/
