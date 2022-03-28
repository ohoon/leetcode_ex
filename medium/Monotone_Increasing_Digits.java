/*
738.
Monotone Increasing Digits
https://leetcode.com/problems/monotone-increasing-digits/
*/

class Solution {
    private int getNumLength(int n) {       // 정수의 digit 길이를 반환하는 메서드
        int len = 0;
        do {
            len++;
            n /= 10;
        } while (n > 0);
        
        return len;
    }
    
    public int monotoneIncreasingDigits(int n) {
        int len = getNumLength(n);
        int[] digits = new int[len];            // n을 1차원 정수 배열로 변환
        for (int i = len-1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (digits[i] <= digits[i+1]) {
                continue;
            }
            
            for (int j = i; j >= 0; j--) {          // increasing하지 않은 digit을 발견하면 그 전 digit들을 재탐색
                if (j == 0 || digits[j] > digits[j-1]) {        // 완벽히 increase한 관계인 digit을 발견하면 해당 digit을 1 감소시키고 그 이후의 digit을 9로 바꿈
                    digits[j]--;
                    for (int k = j+1; k < len; k++) {
                        digits[k] = 9;
                    }
                    
                    break;
                }
            }
            
            break;
        }
        
        int answer = 0;
        for (int i = 0; i < len; i++) {         // 1차원 배열인 digits[]를 int 자료형으로 변환하는 과정
            answer += digits[i] * Math.pow(10, len - i - 1);
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 68.85% of Java online submissions for Monotone Increasing Digits.
Memory Usage: 42 MB, less than 7.41% of Java online submissions for Monotone Increasing Digits.
*/
