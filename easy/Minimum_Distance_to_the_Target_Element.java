/*
1848.
Minimum Distance to the Target Element
https://leetcode.com/problems/minimum-distance-to-the-target-element/
*/

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        for (int offset = 0; offset < nums.length; offset++) {
            int left = start - offset;      // start 기준 왼쪽으로 이동한 포인터
            int right = start + offset;     // start 기준 오른쪽으로 이동한 포인터
            if ((left >= 0 && nums[left] == target) || (right < nums.length && nums[right] == target)) {    // 타겟 발견시 오프셋 반환
                return offset;
            }
        }

        return -1;      // 타겟이 발견되지 않으면 -1 반환
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance to the Target Element.
Memory Usage: 38.6 MB, less than 77.12% of Java online submissions for Minimum Distance to the Target Element.
*/
