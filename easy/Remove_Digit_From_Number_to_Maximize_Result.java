/*
2259.
Remove Digit From Number to Maximize Result
https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
*/

class Solution {
    public String removeDigit(String number, char digit) {
        int n = number.length();
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) != digit) {
                continue;
            }
            
            prev = i;           // 찾은 위치를 prev에 저장
            if (i == n-1) {     // 마지막 숫자가 digit이라면 해당 위치의 숫자를 제거하고 종료
                return number.substring(0, n-1);
            }
            
            if (number.charAt(i) >= number.charAt(i+1)) {       // i+1 숫자가 i 숫자 이하라면 지우지 않음
                continue;
            }
            
            return number.substring(0, i) + number.substring(i+1);      // i+1 숫자가 i 숫자보다 커야 maximize한 결과값을 얻을 수 있음
        }
        
        return number.substring(0, prev) + number.substring(prev+1);    // 모든 경우가 number.charAt(i) >= number.charAt(i+1)일 때 가장 낮은 자리의 digit을 제거
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Remove Digit From Number to Maximize Result.
Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Remove Digit From Number to Maximize Result.
*/
