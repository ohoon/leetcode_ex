/*
866.
Prime Palindrome
https://leetcode.com/problems/prime-palindrome/
*/

class Solution {
    private int getLength(int n) {      // 정수 n의 digit 길이를 반환하는 함수
        int len = 0;
        while (n > 0) {
            len++;
            n /= 10;
        }
        
        return len;
    }
    
    private boolean isPalindrome(int n) {       // 정수 n이 대칭형인지 반환하는 함수
        int res = 0, tmp = n;
        while (tmp > 0) {                       // res = n의 reverse 모양인 정수
            res = res * 10 + tmp % 10;
            tmp /= 10;
        }
        
        return res == n;
    }
    
    private boolean isPrime(int n) {            // 정수 n이 prime인지 반환하는 함수
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return n > 1;
    }
    
    public int primePalindrome(int n) {
        while (true) {
            int length = getLength(n);
            if (length % 2 == 0) {              // digit의 길이가 짝수이고, 대칭형인 정수들은 모두 11의 배수임
                if (n <= 11) {
                    return 11;
                }
                
                n = (int) Math.pow(10, length); // digit의 길이가 홀수인 정수로 n값을 바꿔줌
                continue;
            }
            
            if (!isPalindrome(n) || !isPrime(n)) {      // 대칭형이 아니거나 prime이 아니면 n을 증가시키고 continue
                n++;
                continue;
            }
            
            break;      // 대칭형이고 prime인 정수 n을 발견하면 while문 종료
        }
        
        return n;
    }
}

/*
Runtime: 46 ms, faster than 51.08% of Java online submissions for Prime Palindrome.
Memory Usage: 37.6 MB, less than 66.67% of Java online submissions for Prime Palindrome.
*/

/*
여담

생각보다 time limit이 많이 떠서 최적화하는데 어려움을 많이 겪었다.
대칭형이고 digit 개수가 짝수인 숫자들은 모두 11의 배수라는 힌트를 보고 어떻게 최적화해야할지 감을 잡았던 것 같다.

*/
