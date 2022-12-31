/*
1545.
Find Kth Bit in Nth Binary String
https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
*/

class Solution {
    private String invertAndReverseBit(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i) == '1' ? 0 : 1);
        }

        return sb.toString();
    }

    private String operation(String prev, int n) {
        if (n == 0) {
            return prev;
        }

        return operation(prev + "1" + invertAndReverseBit(prev), n-1);
    }

    public char findKthBit(int n, int k) {
        return operation("0", n-1).charAt(k-1);
    }
}
