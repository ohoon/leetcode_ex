/*
1185.
Day of the Week
https://leetcode.com/problems/day-of-the-week/
*/

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] monthOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = day;
        
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {                    // 윤달이면 1년은 366일
                days += 366;
            } else {
                days += 365;
            }
        }
        
        if (isLeapYear(year)) {                     // 윤달이면 2월의 말일은 29
            monthOfDays[1] = 29;
        }
        
        for (int i = 0; i < month - 1; i++) {
            days += monthOfDays[i];
        }
        
        return weeks[(days + 4) % 7];
    }
    
    public boolean isLeapYear(int year) {           // 윤달 계산 함수
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Day of the Week.
Memory Usage: 36.5 MB, less than 40.47% of Java online submissions for Day of the Week.
*/
