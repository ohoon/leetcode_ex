/*
1694.
Reformat Phone Number
https://leetcode.com/problems/reformat-phone-number/
*/

class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        String trim = number.replace("-", "").replace(" ", "");     // 숫자를 제외한 문자 제거
        int prev = 0;
        for (int i = 0; i < trim.length(); i++) {
            int rest = trim.length() - i;           // 남은 숫자 개수
            if (prev == 3) {                        // 3개의 숫자를 지나왔으면 - 삽입
                sb.append("-");
                prev = 0;
            } else if (prev == 2 && rest == 2) {    // 2개의 숫자를 지나왔고 남은 숫자가 2개면 - 삽입
                sb.append("-");
                prev = 0;
            }
            
            sb.append(trim.charAt(i));
            prev++;
        }
        
        return sb.toString();
    }
}

/*
Runtime: 1 ms, faster than 97.86% of Java online submissions for Reformat Phone Number.
Memory Usage: 36.9 MB, less than 97.20% of Java online submissions for Reformat Phone Number.
*/
