/*
2224.
Minimum Number of Operations to Convert Time
https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
*/

class Solution {
    private int convert(String format) {        // time의 string format을 int형으로 변환하는 메서드
        String[] t = format.split(":");
        return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
    }
    
    public int convertTime(String current, String correct) {
        int answer = 0;
        int diff = convert(correct) - convert(current);     // 목표 시간과 현재 시간과의 시간 차
        while (diff > 0) {
            if (diff >= 60) {           // 60, 15, 5, 1 우선순위로 시간 차를 줄여감
                answer += diff / 60;
                diff %= 60;
                continue;
            }
            
            if (diff >= 15) {
                answer += diff / 15;
                diff %= 15;
                continue;
            }
            
            if (diff >= 5) {
                answer += diff / 5;
                diff %= 5;
                continue;
            }
            
            return answer + diff;
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 80.00% of Java online submissions for Minimum Number of Operations to Convert Time.
Memory Usage: 40.8 MB, less than 80.00% of Java online submissions for Minimum Number of Operations to Convert Time.
*/
