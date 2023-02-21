/*
2566.
Maximum Difference by Remapping a Digit
https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/
*/

class Solution {
    public int minMaxDifference(int num) {
        Integer max = null, min = null;
        String numStr = String.valueOf(num);
        int n = numStr.length();
        int i = 0;
        while (i < n && (max == null || min == null)) {
            if (max == null && numStr.charAt(i)-'0' < 9) {
                max = Integer.valueOf(numStr.replaceAll(String.valueOf(numStr.charAt(i)), "9"));
            }

            if (min == null && numStr.charAt(i)-'0' > 0) {
                min = Integer.valueOf(numStr.replaceAll(String.valueOf(numStr.charAt(i)), "0"));
            }

            i++;
        }

        return max == null || min == null ? num : max - min;
    }
}
