/*
2729.
Check if The Number is Fascinating
https://leetcode.com/problems/check-if-the-number-is-fascinating/
*/

class Solution {
    public boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            sb.append(String.valueOf(n*i));
        }

        String str = sb.toString();
        boolean[] check = new boolean[10];
        for (char ch : str.toCharArray()) {
            if (check[ch-'0']) {
                return false;
            }

            check[ch-'0'] = true;
        }

        for (int i = 1; i < 10; i++) {
            if (!check[i]) {
                return false;
            }
        }

        return true;
    }
}
