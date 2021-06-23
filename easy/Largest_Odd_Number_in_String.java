/*
1903.
Largest Odd Number in String
https://leetcode.com/problems/largest-odd-number-in-string/
*/

class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {       // 끝에서부터 탐색하여 홀수가 나오면 해당 자리수 기준 왼쪽 문자열을 반환
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i+1);
            }
        }
        
        return "";
    }
}

/*
Runtime: 1 ms, faster than 99.96% of Java online submissions for Largest Odd Number in String.
Memory Usage: 40 MB, less than 68.58% of Java online submissions for Largest Odd Number in String.
*/
