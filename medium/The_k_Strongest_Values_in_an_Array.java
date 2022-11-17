/*
1471.
The k Strongest Values in an Array
https://leetcode.com/problems/the-k-strongest-values-in-an-array/
*/

class Solution {
    public int[] getStrongest(int[] arr, int k) {       // sort + two pointer
        int[] answer = new int[k];
        int n = arr.length;
        Arrays.sort(arr);
        int m = arr[(n-1)/2];
        int L = 0, R = n-1;     // 가장 작은 값과 가장 큰 값부터 시작
        for (int i = 0; i < k; i++) {
            int lVal = m - arr[L];
            int rVal = arr[R] - m;
            if (lVal <= rVal) {
                answer[i] = arr[R--];
            } else {
                answer[i] = arr[L++];
            }
        }

        return answer;
    }
}
