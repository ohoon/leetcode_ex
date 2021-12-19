/*
137.
Single Number II
https://leetcode.com/problems/single-number-ii/
*/

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);      // 오름차순으로 정렬
        for (int i = 0; i < nums.length - 1; i += 3) {      // 3개 단위로 탐색
            if (nums[i] != nums[i+1]) {         // 불연속적인 것으로 나오면 해당 숫자는 single number
                return nums[i];
            }
        }
        
        return nums[nums.length-1];
    }
}

/*
Runtime: 1 ms, faster than 80.03% of Java online submissions for Single Number II.
Memory Usage: 38.6 MB, less than 65.60% of Java online submissions for Single Number II.
*/
