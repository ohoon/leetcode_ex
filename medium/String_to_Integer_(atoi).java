/*
8.
String to Integer (atoi)
https://leetcode.com/problems/string-to-integer-atoi/
*/

class Solution {
    public int myAtoi(String s) {
        int answer = 0, cur = 0;
        int sign = 1;
        s = s.trim();           // 공백 제거
        if (s.isEmpty()) {
            return 0;
        }
        
        if (s.charAt(0) == '+') {       // 부호 설정
            sign = 1;
            cur = 1;
        } else if (s.charAt(0) == '-') {
            sign = -1;
            cur = 1;
        }
        
        while (cur < s.length() && s.charAt(cur) - '0' >= 0 && s.charAt(cur) - '0' < 10) {      // 연속된 숫자가 끝날때까지 반복
            if (
                answer > Integer.MAX_VALUE / 10 ||
                (answer == Integer.MAX_VALUE / 10 && s.charAt(cur) - '0' > Integer.MAX_VALUE % 10)      // 오버플로우나 언더플로우가 일어나기 바로 전 상태에서 체크
               ) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            answer = answer * 10 + s.charAt(cur) - '0';
            cur++;
        }
        
        return sign * answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
Memory Usage: 38.9 MB, less than 63.48% of Java online submissions for String to Integer (atoi).
*/

/*
여담

물론 Integer 클래스에서 제공하는 parseInt 함수를 사용하면 오버플로우/언더플로우를 제외한 로직을 생략해도 된다.
하지만 이 문제에서 의도한 것은 그것이 아니라고 생각하고 최대한 라이브러리를 사용하지 않고 구현하였다.

*/
