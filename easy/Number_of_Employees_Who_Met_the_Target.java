/*
2798.
Number of Employees Who Met the Target
https://leetcode.com/problems/number-of-employees-who-met-the-target/
*/

class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int answer = 0;
        for (int hour : hours) {
            if (hour < target) {
                continue;
            }

            answer++;
        }

        return answer;
    }
}
