/*
2295.
Replace Elements in an Array
https://leetcode.com/problems/replace-elements-in-an-array/
*/

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, m = operations.length;
        for (int i = m-1; i >= 0; i--) {        // operations을 역순으로 map에 기록
            map.put(operations[i][0], map.getOrDefault(operations[i][1], operations[i][1]));        // 뒤이어 replace될 결과를 미리 반영
        }

        for (int i = 0; i < n; i++) {
            nums[i] = map.getOrDefault(nums[i], nums[i]);       // map에 있는 관계대로 nums를 수정
        }

        return nums;
    }
}
