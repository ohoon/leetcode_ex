/*
1464.
Maximum Product of Two Elements in an Array
https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
*/

class Solution {
    public int maxProduct(int[] nums) {
        int first = Math.max(nums[0], nums[1]);         // 가장 큰 수
        int second = Math.min(nums[0], nums[1]);        // 2번째로 큰 수
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > first) {                      // 가장 큰 수보다 크면 first 갱신
                second = first;
                first = nums[i];
                continue;
            }
            
            if (nums[i] > second) {                     // 가장 큰 수보다는 작고 2번째로 큰 수보다 크면 second 갱신
                second = nums[i];
                continue;
            }
        }
        
        return (first - 1) * (second - 1);
    }
}

/*
Runtime: 1 ms, faster than 58.58% of Java online submissions for Maximum Product of Two Elements in an Array.
Memory Usage: 40.5 MB, less than 5.54% of Java online submissions for Maximum Product of Two Elements in an Array.
*/
