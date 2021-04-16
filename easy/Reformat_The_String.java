/*
1417.
Reformat The String
https://leetcode.com/problems/reformat-the-string/
*/

class Solution {
    public String reformat(String s) {
        List<Character> digit = new ArrayList<>();
        List<Character> alpha = new ArrayList<>();
        for (char c : s.toCharArray()) {                // digit, alpha 별로 분리
            if (Character.isDigit(c)) {
                digit.add(c);
            } else {
                alpha.add(c);
            }
        }
        
        int digitSize = digit.size();
        int alphaSize = alpha.size();
        if (Math.abs(digitSize - alphaSize) > 1) {          // 최소 조건을 성립하지 못하면 빈 문자열 반환
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(digitSize, alphaSize); i++) {      // 공통 부분으로 digit-alpha 순서로 삽입
            sb.append(digit.get(i));
            sb.append(alpha.get(i));
        }
        
        if (digitSize > alphaSize) {                        // digit이 더 많으면 끝 부분에 digit 추가
            sb.append(digit.get(digitSize-1));
        } else if (alphaSize > digitSize) {                 // alpha가 더 많으면 첫 부분에 alphabet 추가
            sb.reverse();
            sb.append(alpha.get(alphaSize-1));
            sb.reverse();
        }
        
        return sb.toString();
        
    }
}

/*
Runtime: 5 ms, faster than 45.44% of Java online submissions for Reformat The String.
Memory Usage: 39.1 MB, less than 65.10% of Java online submissions for Reformat The String.
*/
