/*
1913.
Maximum Product Difference Between Two Pairs
https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
*/

class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-1] * nums[n-2] - nums[1] * nums[0];       // 가장 큰 두 수의 곱에서 가장 작은 두 수의 곱을 빼서 반환
    }
}

/*
Runtime: 6 ms, faster than 70.37% of Java online submissions for Maximum Product Difference Between Two Pairs.
Memory Usage: 38.9 MB, less than 89.28% of Java online submissions for Maximum Product Difference Between Two Pairs.
*/
