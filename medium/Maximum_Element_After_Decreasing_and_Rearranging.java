/*
1846.
Maximum Element After Decreasing and Rearranging
https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
*/

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);       // 오름차순 정렬 (rearrange)
        arr[0] = 1;             // 첫번째 요소는 항상 1이 되도록 decrease
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1] + 1) {        // 조건에 성립하지 않으면 성립하도록 decrease
                arr[i] = arr[i-1] + 1;
            }
        }
        
        return arr[n-1];        // 최대값인 마지막 요소 반환
    }
}

/*
Runtime: 13 ms, faster than 17.49% of Java online submissions for Maximum Element After Decreasing and Rearranging.
Memory Usage: 71.8 MB, less than 9.46% of Java online submissions for Maximum Element After Decreasing and Rearranging.
*/
