/*
1450.
Number of Students Doing Homework at a Given Time
https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
*/

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int answer = 0;
        for (int i = 0; i < startTime.length; i++) {
+) {

11

            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {         // queryTime이 startTime[i]와 endTime[i] 사이면 answer 증가            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {         // queryTime이 startTime[i]와 endTime[i] 사이면 answer 증가
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Students Doing Homework at a Given Time.
Memory Usage: 37 MB, less than 37.57% of Java online submissions for Number of Students Doing Homework at a Given Time.
*/
