/*
540.
Single Element in a Sorted Array
https://leetcode.com/problems/single-element-in-a-sorted-array/
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {      // [nums[left], nums[right]]가 될 때까지 반복
            int mid = (left + right) / 2;
            if (mid % 2 == 0) {                     // mid가 짝수라면 mid 포함 앞까지 요소의 개수가 홀수
                if (nums[mid-1] == nums[mid]) {     // 정답요소가 mid 전에 있다면 nums[mid-1]와 nums[mid]는 같아야함
                    right = mid;
                } else {                            // 아니라면 정답요소는 mid 뒤에 있음
                    left = mid;
                }
            } else {
                if (nums[mid-1] == nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        
        if (left == 0 || nums[left-1] != nums[left]) {      // 남은 2개의 요소인 nums[left], nums[right]만 탐색해서 추론하면 됨
            return nums[left];
        }
        
        return nums[right];
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Element in a Sorted Array.
Memory Usage: 39.4 MB, less than 38.79% of Java online submissions for Single Element in a Sorted Array.
*/
