/*
1877.
Partition to K Equal Sum Subsets
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
*/

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);      // 오름차순 정렬
        int answer = -1, n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            answer = Math.max(answer, nums[i] + nums[n-i-1]);       // 배열에서 가장 작은 값과 가장 큰 값을 더한 것이 pair sum의 최솟값이 될 수 있음
        }
        
        return answer;
    }
}

/*
Runtime: 50 ms, faster than 68.61% of Java online submissions for Minimize Maximum Pair Sum in Array.
Memory Usage: 55 MB, less than 28.34% of Java online submissions for Minimize Maximum Pair Sum in Array.
*/
