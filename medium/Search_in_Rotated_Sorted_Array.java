/*
33.
Search in Rotated Sorted Array
https://leetcode.com/problems/search-in-rotated-sorted-array/
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] > nums[right]) {             // left, mid, right를 비교하여 가장 작은 위치를 기준으로 이진 탐색
                if (left == mid) {
                    left = right;
                    continue;
                }
                
                if (nums[mid] > nums[right]) {
                    left = mid;
                    continue;
                }
                
                right = mid;
            } else {
                break;
            }
        }
        
        int pivot = left;                           // 정렬이 시작되는 지점
        for (int i = 0; i < nums.length; i++) {     // pivot부터 시작하여 target 탐색
            int index = (pivot + i) % nums.length;
            if (nums[index] == target) {
                return index;
            }
        }
        
        return -1;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
Memory Usage: 39.8 MB, less than 7.51% of Java online submissions for Search in Rotated Sorted Array.
*/
