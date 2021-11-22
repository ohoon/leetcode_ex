/*
560.
Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = (nums[0] == k ? 1 : 0);        // nums[0] 자체가 k가 되는 경우 1로 초기화
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];       // nums값을 앞에서부터 차례대로 누적시킴
            if (nums[i] == k) {         // nums[0]~nums[i]의 합이 k가 되면 answer 증가
                answer++;
            }
        }
        
        for (int i = 0; i < nums.length-1; i++) {       // nums[i]~nums[j]의 합이 k가 되면 answer 증가
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1129 ms, faster than 21.19% of Java online submissions for Subarray Sum Equals K.
Memory Usage: 41.2 MB, less than 84.56% of Java online submissions for Subarray Sum Equals K.
*/
