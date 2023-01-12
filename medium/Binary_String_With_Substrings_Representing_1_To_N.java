/*
1016.
Binary String With Substrings Representing 1 To N
https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
*/

class Solution {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }

        return true;
    }
}
