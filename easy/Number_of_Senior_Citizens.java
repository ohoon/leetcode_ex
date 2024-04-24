/*
2678.
Number of Senior Citizens
https://leetcode.com/problems/number-of-senior-citizens/
*/

class Solution {
    public int countSeniors(String[] details) {
        int answer = 0;
        for (String detail : details) {
            int age = Integer.valueOf(detail.substring(11,13));
            if (age > 60) {
                answer++;
            }
        }

        return answer;
    }
}
