/*
1447.
Simplified Fractions
https://leetcode.com/problems/simplified-fractions/
*/

class Solution {
    private int getGCD(int n, int m) {          // 최대공약수를 구하는 함수
        for (int i = m; i > 1; i--) {
            if (n % i == 0 && m % i == 0) {
                return i;
            }
        }
        
        return 1;
    }
    
    public List<String> simplifiedFractions(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 2; i <= n; i++) {                  // 분모 i
            for (int j = 1; j < i; j++) {               // 분자 j
                if (j != 1 && getGCD(i, j) > 1) {       // 최대공약수가 1을 초과하는 조합은 선택하지 않음
                    continue;
                }
                
                answer.add(j + "/" + i);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 28 ms, faster than 57.96% of Java online submissions for Simplified Fractions.
Memory Usage: 39.8 MB, less than 85.99% of Java online submissions for Simplified Fractions.
*/
