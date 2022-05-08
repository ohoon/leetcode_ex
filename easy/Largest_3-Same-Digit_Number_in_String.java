/*
2264.
Largest 3-Same-Digit Number in String
https://leetcode.com/problems/largest-3-same-digit-number-in-string/
*/

class Solution {
    public String largestGoodInteger(String num) {
        String answer = "";
        for (int i = 0; i < num.length()-2; i++) {      // 3개의 digit으로 이루어진 블럭으로 탐색
            if (num.charAt(i) != num.charAt(i+1) || num.charAt(i+1) != num.charAt(i+2)) {       // 3-same-digit number이 아니면 넘김
                continue;
            }
            
            if (answer.length() == 0 || answer.charAt(0) < num.charAt(i)) {     // answer의 문자열보다 값이 크면 answer 값 갱신
                answer = num.substring(i, i+3);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Largest 3-Same-Digit Number in String.
Memory Usage: 40.5 MB, less than 66.67% of Java online submissions for Largest 3-Same-Digit Number in String.
*/
