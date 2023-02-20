/*
2570.
Merge Two 2D Arrays by Summing Values
https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
*/

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {          // Two Pointer
        List<int[]> list = new ArrayList<>();
        int len1 = nums1.length, len2 = nums2.length;
        int cur1 = 0, cur2 = 0;
        while (cur1 < len1 || cur2 < len2) {
            if (cur1 == len1 || (cur2 != len2 && nums1[cur1][0] > nums2[cur2][0])) {
                list.add(new int[]{nums2[cur2][0], nums2[cur2++][1]});
                continue;
            }

            if (cur2 == len2 || (cur1 != len1 && nums1[cur1][0] < nums2[cur2][0])) {
                list.add(new int[]{nums1[cur1][0], nums1[cur1++][1]});
                continue;
            }

            if (nums1[cur1][0] == nums2[cur2][0]) {
                list.add(new int[]{nums1[cur1][0], nums1[cur1++][1] + nums2[cur2++][1]});
                continue;
            }
        }
        
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
