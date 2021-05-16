/*
1763.
Latest Time by Replacing Hidden Digits
https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
*/

class Solution {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (time.charAt(i) != '?') {            // 마스킹이 안된 경우 그대로 append
                sb.append(time.charAt(i));
                continue;
            }
            
            if (i == 0) {                           // 시간의 십의 자리 경우
                if (time.charAt(1) == '?' || time.charAt(1) < '4') {        // 시간의 일의 자리가 마스킹 되어있거나 0, 1, 2, 3인 경우 23시간이 최대
                    sb.append('2');
                    continue;
                } else {                                                    // 아닌 경우 19시간이 최대
                    sb.append('1');
                    continue;
                }
            }
            
            if (i == 1) {                           // 시간의 일의 자리 경우
                if (time.charAt(0) == '2' || time.charAt(0) == '?') {       // 시간의 십의 자리가 마스킹 되어있거나 2인 경우 23시간이 최대
                    sb.append('3');
                    continue;
                } else {                                                    // 아닌 경우 19시간이 최대
                    sb.append('9');
                    continue;
                }
            }
            
            if (i == 3) {                                                   // 분의 십의 자리 경우 59분이 최대
                sb.append('5');
                continue;
            }
            
            if (i == 4) {                                                   // 분의 일의 자리 경우 59분이 최대
                sb.append('9');
                continue;
            }
        }
        
        return sb.toString();
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Latest Time by Replacing Hidden Digits.
Memory Usage: 37.5 MB, less than 29.45% of Java online submissions for Latest Time by Replacing Hidden Digits.
*/
