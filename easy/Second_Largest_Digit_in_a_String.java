/*
1796.
Second Largest Digit in a String
https://leetcode.com/problems/second-largest-digit-in-a-string/
*/

class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0) {     // 0 ~ 9인 숫자라면
                int num = s.charAt(i) - '0';
                if (num > first) {              // 가장 큰 수라면
                    second = first;
                    first = num;
                } else if (num == first) {      // 기존의 가장 큰 수와 같다면 중복이므로 다음 숫자로 건너뜀
                    continue;
                } else if (num > second) {      // 2번째로 큰 수라면
                    second = num;
                }
            }
        }
        
        return second;
    }
}

/*
Runtime: 1 ms, faster than 99.61% of Java online submissions for Second Largest Digit in a String.
Memory Usage: 37.3 MB, less than 88.44% of Java online submissions for Second Largest Digit in a String.
*/
