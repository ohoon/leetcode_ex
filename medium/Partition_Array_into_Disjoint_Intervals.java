/*
915.
Partition Array into Disjoint Intervals
https://leetcode.com/problems/partition-array-into-disjoint-intervals/
*/

class Solution {
    public int partitionDisjoint(int[] nums) {
        int curr = nums[0], max = nums[0];      // curr: 0 ~ p 범위에서의 최대값, max: 탐색한 범위에서의 최대값
        int p = 0;          // 파티션 인덱스
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);       // 배열을 탐색하면서 max는 항상 갱신
            if (nums[i] < curr) {               // curr보다 작은 값이 나타나면 파티션 인덱스를 갱신하고 curr를 max로 바꿈
                p = i;
                curr = max;
            }
        }
        
        return p+1;
    }
}

/*
Runtime: 3 ms, faster than 81.78% of Java online submissions for Partition Array into Disjoint Intervals.
Memory Usage: 87.5 MB, less than 70.79% of Java online submissions for Partition Array into Disjoint Intervals.
*/
