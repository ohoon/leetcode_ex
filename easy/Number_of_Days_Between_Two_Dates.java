/*
1360.
Number of Days Between Two Dates
https://leetcode.com/problems/number-of-days-between-two-dates/
*/

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(dateToDays(date1) - dateToDays(date2));
    }
    
    private int dateToDays(String date) {
        int[] split = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int year = split[0];
        int month = split[1];
        int day = split[2];
        
        int result = day;
        if (isLeapYear(year)) {
            days[1] = 29;
        }
        
        for (int i = 1970; i < year; i++) {
            if (isLeapYear(i)) {
                result += 366;
            } else {
                result += 365;
            }
        }
        
        for (int i = 0; i < month - 1; i++) {
            result += days[i];
        }
        
        return result;
    }
    
    private boolean isLeapYear(int year) {
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
Runtime: 5 ms, faster than 29.69% of Java online submissions for Number of Days Between Two Dates.
Memory Usage: 37.5 MB, less than 30.99% of Java online submissions for Number of Days Between Two Dates.
*/

/*
여담

사실 이 문제는 1970년부터 해당 년도까지의 총 일수를 세어서 차이를 구하는 것보단 두 날짜의 차이를 직접 구해서 반환하는 것이 더 효율적이다.
하지만 그렇게 구현할려면 코드가 너무 복잡해지고 여러가지 변수를 생각해지는게 많아져서 1970년부터의 일수를 구해서 빼는 식의 방법을 선택했다.

*/
