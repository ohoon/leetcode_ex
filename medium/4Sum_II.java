/*
454.
4Sum II
https://leetcode.com/problems/4sum-ii/
*/

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {          // nums1과 nums2의 sum 조합값들을 해시맵에 저장
            for (int n2 : nums2) {
                int sum = n1 + n2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        for (int n3 : nums3) {          
            for (int n4 : nums4) {
                int needed = -(n3 + n4);        // 0 - nums3과 nums4의 sum 조합값 = 필요한 nums1과 nums2의 sum 조합값
                if (map.containsKey(needed)) {  // 해시맵에 등록된 조합값일 경우
                    answer += map.get(needed);
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 118 ms, faster than 86.26% of Java online submissions for 4Sum II.
Memory Usage: 42.4 MB, less than 87.77% of Java online submissions for 4Sum II.
*/
