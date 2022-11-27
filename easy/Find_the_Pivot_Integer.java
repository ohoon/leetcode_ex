/*
2485.
Find the Pivot Integer
https://leetcode.com/problems/find-the-pivot-integer/
*/

class Solution {
    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {      // 누적값
            arr[i] = arr[i-1] + i;
        }

        int L = 0, R = n+1;
        while (L < R) {                 // binary search
            int m = (L + R) / 2;
            if (arr[m] == arr[n] - arr[m-1]) {
                return m;
            }

            if (arr[m] < arr[n] - arr[m-1]) {
                L = m + 1;
            } else {
                R = m;
            }
        }

        return -1;
    }
}
