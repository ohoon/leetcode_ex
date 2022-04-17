/*
2243.
Calculate Digit Sum of a String
https://leetcode.com/problems/calculate-digit-sum-of-a-string/
*/

class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {        // s 길이가 k 이하가 될 때까지 반복
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {       // k개 단위로 문자열을 쪼개서 작업
                int sum = 0;
                for (int j = i; j < i+k; j++) {     // 각 구간의 digit sum 값을 계산
                    if (j >= s.length()) {
                        break;
                    }
                    
                    sum += s.charAt(j) - '0';
                }
                
                sb.append(String.valueOf(sum));     // sum을 문자열로 바꿔서 StringBuilder에 삽입
            }
            
            s = sb.toString();      // 모든 작업이 끝난 결과물로 s를 대체
        }
        
        return s;
    }
}

/*
Runtime: 1 ms, faster than 80.00% of Java online submissions for Calculate Digit Sum of a String.
Memory Usage: 40.6 MB, less than 80.00% of Java online submissions for Calculate Digit Sum of a String.
*/
