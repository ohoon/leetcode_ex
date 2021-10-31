/*
2057.
Smallest Index With Equal Value
https://leetcode.com/problems/smallest-index-with-equal-value/
*/

class Solution {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {        // 조건 성립하면 인덱스 반환
                return i;
            }
        }
        
        return -1;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Smallest Index With Equal Value.
Memory Usage: 38.8 MB, less than 66.67% of Java online submissions for Smallest Index With Equal Value.
*/
