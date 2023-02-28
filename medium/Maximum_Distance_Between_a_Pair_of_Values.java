/*
1855.
Maximum Distance Between a Pair of Values
https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
*/

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {      // two pointer
        int answer = 0, n = nums1.length, m = nums2.length, cur = 0;
        for (int i = 0; i < n; i++) {
            cur = Math.max(i, cur);
            while (cur < m && nums1[i] <= nums2[cur]) {
                answer = Math.max(answer, cur - i);
                cur++;
            }

            if (cur == m) {
                break;
            }
        }

        return answer;
    }
}
