/*
201.
Bitwise AND of Numbers Range
https://leetcode.com/problems/bitwise-and-of-numbers-range/
*/

class Solution {
    private int getBitLength(int num) {     // 비트 길이를 구하는 메서드
        int len = 0;
        while (num > 0) {
            num >>= 1;
            len++;
        }
        
        return len;
    }
    
    public int rangeBitwiseAnd(int left, int right) {
        int answer = 0;
        int n = getBitLength(left);
        if (Math.pow(2, n) <= right) {      // 비트 자리수가 다르면 AND 연산 결과는 무조건 0
            return 0;
        }
        
        for (int i = n-1; i >= 0; i--) {        // 맨 왼쪽 비트부터 차례대로 비교
            int curr = (int) Math.pow(2, i);
            if (left < curr && right < curr) {      // 현재 비트가 left right 모두 0, 0이면 다음 비트로
                continue;
            }
            
            if (left < curr || right < curr) {      // 하나의 비트만 1이면 그 이하의 비트는 모두 AND 연산시 000..00임
                break;
            }
            
            left -= curr;       // 현재 비트의 값을 left, right에서 빼주고 answer에 더해줌
            right -= curr;
            answer += curr;
        }
        
        return answer;
    }
}

/*
Runtime: 8 ms, faster than 63.64% of Java online submissions for Bitwise AND of Numbers Range.
Memory Usage: 44.6 MB, less than 9.09% of Java online submissions for Bitwise AND of Numbers Range.
*/
