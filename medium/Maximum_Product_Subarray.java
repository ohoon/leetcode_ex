/*
152.
Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/
*/

class Solution {
    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;     // max의 복제본 준비
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);        // 현재 요소를 max와 min에 각각 곱한 뒤에 갱신
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);       // 일반적으로 nums[i]가 음수이면 min * nums[i]가 max가 될 가능성이 높음
            answer = Math.max(answer, max);
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 71.71% of Java online submissions for Maximum Product Subarray.
Memory Usage: 44.9 MB, less than 53.33% of Java online submissions for Maximum Product Subarray.
*/
