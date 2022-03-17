/*
264.
Ugly Number II
https://leetcode.com/problems/ugly-number-ii/
*/

class Solution {
    public int nthUglyNumber(int n) {       // dynamic programming
        int[] arr = new int[n];
        arr[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;         // 2, 3, 5 인덱스 포인트
        int n2 = 2, n3 = 3, n5 = 5;         // 2, 3, 5 기대값
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(n2, n3), n5);       // 기대값이 제일 작은 것을 고름
            arr[i] = min;
            if (n2 == min) {            // 2를 약수를 가질 경우 2의 인덱스를 늘려주고 n2를 갱신
                n2 = 2 * arr[++i2];
            }
            
            if (n3 == min) {            // 3, 5의 경우도 동일함
                n3 = 3 * arr[++i3];
            }
            
            if (n5 == min) {
                n5 = 5 * arr[++i5];
            }
        }
        
        return arr[n-1];
    }
}

/*
Runtime: 4 ms, faster than 80.59% of Java online submissions for Ugly Number II.
Memory Usage: 42.2 MB, less than 50.72% of Java online submissions for Ugly Number II.
*/
