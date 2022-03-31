/*
1508.
Range Sum of Sorted Subarray Sums
https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
*/

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n*(n+1)/2];     // 각 subarray의 sum 값을 담을 배열 정의
        int idx = 0;                        // 현재 arr에 sum 값을 넣을 인덱스
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {   // nums[i] ~ nums[j]의 요소를 가지고 있는 subarray의 sum 값을 arr에 삽입
                sum += nums[j];
                arr[idx++] = sum;
            }
        }
        
        Arrays.sort(arr);           // 오름차순 정렬
        int answer = 0;
        int mod = 1000000007;
        for (int i = left-1; i < right; i++) {      // left부터 right까지의 sum 값만 answer에 더해줌
            answer += arr[i];
            answer %= mod;
        }
        
        return answer;
    }
}

/*
Runtime: 116 ms, faster than 66.17% of Java online submissions for Range Sum of Sorted Subarray Sums.
Memory Usage: 54.7 MB, less than 59.40% of Java online submissions for Range Sum of Sorted Subarray Sums.
*/
