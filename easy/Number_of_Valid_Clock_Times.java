/*
2437.
Number of Valid Clock Times
https://leetcode.com/problems/number-of-valid-clock-times/
*/

class Solution {
    public int countTime(String time) {
        int answer = 1;
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        if (hour.charAt(0) == '?') {
            if (hour.charAt(1) == '?') {
                answer *= 24;
            } else if (hour.charAt(1) > '3') {
                answer *= 2;
            } else {
                answer *= 3;
            }
        } else if (hour.charAt(1) == '?') {
            if (hour.charAt(0) == '2') {
                answer *= 4;
            } else {
                answer *= 10;
            }
        }
        
        if (minute.charAt(0) == '?') {
            if (minute.charAt(1) == '?') {
                answer *= 60;
            } else {
                answer *= 6;
            }
        } else if (minute.charAt(1) == '?') {
            answer *= 10;
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Valid Clock Times.
Memory Usage: 40.1 MB, less than 95.82% of Java online submissions for Number of Valid Clock Times.
*/
