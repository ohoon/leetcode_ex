/*
1015.
Smallest Integer Divisible by K
https://leetcode.com/problems/smallest-integer-divisible-by-k/
*/

class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {     // 2의 배수 또는 5의 배수는 111..11의 약수가 될 수 없기 때문에 -1로 리턴
            return -1;
        }
        
        int answer = 1, n = 1;
        while (n % k != 0) {                // k가 n의 약수일 때까지 반복
            n = (n % k) * 10 + 1;           // 나머지 연산은 결합법칙이 적용됨 ex) (n * 10 + 1) % k = (n % k) * (10 % k) + (1 % k)
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Smallest Integer Divisible by K.
Memory Usage: 35.8 MB, less than 59.26% of Java online submissions for Smallest Integer Divisible by K.
*/
