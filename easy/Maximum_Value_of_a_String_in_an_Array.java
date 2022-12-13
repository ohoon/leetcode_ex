/*
2496.
Maximum Value of a String in an Array
https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/
*/

class Solution {
    public int maximumValue(String[] strs) {
        int answer = 0;
        for (String str : strs) {
            try {
                answer = Math.max(answer, Integer.valueOf(str));
            } catch (NumberFormatException err) {
                answer = Math.max(answer, str.length());
            }
        }

        return answer;
    }
}
