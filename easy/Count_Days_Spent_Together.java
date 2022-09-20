/*
2409.
Count Days Spent Together
https://leetcode.com/problems/count-days-spent-together/
*/

class Solution {
    private int dateToDay(int month, int day) {         // string형인 날짜를 int형인 총 일수로 변환해주는 메서드
        int result = 0;
        int[] dayOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month-1; i++) {
            result += dayOfMonth[i];
        }
        
        return result + day;
    }
    
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] aA = arriveAlice.split("-");
        String[] lA = leaveAlice.split("-");
        String[] aB = arriveBob.split("-");
        String[] lB = leaveBob.split("-");
        int day_aA = dateToDay(Integer.valueOf(aA[0]), Integer.valueOf(aA[1]));
        int day_lA = dateToDay(Integer.valueOf(lA[0]), Integer.valueOf(lA[1]));
        int day_aB = dateToDay(Integer.valueOf(aB[0]), Integer.valueOf(aB[1]));
        int day_lB = dateToDay(Integer.valueOf(lB[0]), Integer.valueOf(lB[1]));
        return Math.max(Math.min(day_lA, day_lB) - Math.max(day_aA, day_aB) + 1, 0);
    }
}

/*
Runtime: 1 ms, faster than 90.85% of Java online submissions for Count Days Spent Together.
Memory Usage: 41.9 MB, less than 67.16% of Java online submissions for Count Days Spent Together.
*/
