/*
1344.
Angle Between Hands of a Clock
https://leetcode.com/problems/angle-between-hands-of-a-clock/
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        double answer;
        double hA, mA;
        if (hour < 12) {
            hA = 30 * (hour + minutes / 60.0);      // 기본 hour에 따른 각도 + minute에 따라 추가되는 각도
        } else {        // 12시의 경우는 0도
            hA = 30 * (minutes / 60.0);
        }
        
        mA = minutes * 6;
        answer = Math.abs(hA - mA);
        if (answer > 180) {         // 두 가지 답 중에 값이 작은 쪽을 반환
            return 360 - answer;
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Angle Between Hands of a Clock.
Memory Usage: 38.1 MB, less than 21.88% of Java online submissions for Angle Between Hands of a Clock.
*/
