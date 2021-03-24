/*
1154.
Day of the Year
https://leetcode.com/problems/day-of-the-year/
*/

class Solution {
    public int dayOfYear(String date) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split_date = date.split("-");
        int year = Integer.parseInt(split_date[0]);
        int month = Integer.parseInt(split_date[1]);
        int day = Integer.parseInt(split_date[2]);
        
        if (year % 4 == 0 && year % 100 != 0) {         // 윤달의 경우 2월은 29일이 말일
            days[1] += 1;
        }
        else if (year % 400 == 0) {
            days[1] += 1;
        }
        
        for (int i = 0; i < month - 1; i++) {           // 지난 달의 일수를 더함
            day += days[i];
        }
        
        return day;
    }
}

/*
Runtime: 1 ms, faster than 96.76% of Java online submissions for Day of the Year.
Memory Usage: 37.1 MB, less than 77.29% of Java online submissions for Day of the Year.
*/
