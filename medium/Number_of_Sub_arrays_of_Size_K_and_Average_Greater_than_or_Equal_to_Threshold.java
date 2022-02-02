/*
1343.
Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
*/

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int target = k * threshold;     // 최소한 넘어야 하는 목표 합
        int sum = 0;
        for (int i = 0; i < k; i++) {   // 첫번째 k개 요소들의 합 계산
            sum += arr[i];
        }
        
        int answer = (sum >= target ? 1 : 0);
        for (int i = k; i < arr.length; i++) {      // sliding window
            sum += arr[i] - arr[i-k];
            if (sum >= target) {
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 78.55% of Java online submissions for Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold.
Memory Usage: 72.5 MB, less than 55.04% of Java online submissions for Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold.
*/
