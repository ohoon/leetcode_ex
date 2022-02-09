/*
2090.
K Radius Subarray Averages
https://leetcode.com/problems/k-radius-subarray-averages/
*/

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] acc = new long[n];       // 누적값을 저장하는 long 배열
        acc[0] = (long) nums[0];
        for (int i = 1; i < n; i++) {   // nums의 값들을 누적시킴
            acc[i] += nums[i] + acc[i-1];
        }
        
        int[] answer = new int[n];
        int size = 2 * k + 1;
        for (int i = 0; i < n; i++) {
            if (i - k < 0 || i + k >= n) {      // 양 옆에 k개의 요소가 있지 않은 경우에는 -1
                answer[i] = -1;
                continue;
            }
            
            if (i == k) {           // acc의 누적 합을 그대로 쓰면 되는 경우
                answer[i] = (int) (acc[i+k] / size);
                continue;
            }
            
            answer[i] = (int) ((acc[i+k] - acc[i-k-1]) / size);     // (i+k까지의 누적합) - (i-k-1까지의 누적합) = (i-k) ~ (i+k)까지의 누적합
        }
        
        return answer;
    }
}

/*
Runtime: 19 ms, faster than 33.40% of Java online submissions for K Radius Subarray Averages.
Memory Usage: 164.4 MB, less than 12.24% of Java online submissions for K Radius Subarray Averages.
*/
