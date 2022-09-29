/*
2294.
Partition Array Such That Maximum Difference Is K
https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
*/

class Solution {
    public int partitionArray(int[] nums, int k) {
        int answer = 1;
        Arrays.sort(nums);      // 오름차순 정렬
        int prev = nums[0];     // partition별 min 값
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prev > k) {
                prev = nums[i];     // partition 이동
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 74 ms, faster than 9.99% of Java online submissions for Partition Array Such That Maximum Difference Is K.
Memory Usage: 75.8 MB, less than 82.62% of Java online submissions for Partition Array Such That Maximum Difference Is K.
*/
