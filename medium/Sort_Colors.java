/*
75.
Sort Colors
https://leetcode.com/problems/sort-colors/
*/

class Solution {
    public void sortColors(int[] nums) {
        int cur = 0, target = 0;
        while (cur < nums.length) {
            for (int i = cur; i < nums.length; i++) {
                if (nums[i] == target) {            // target을 발견하면 cur의 위치와 swap하고 다음 인덱스로 cur 이동
                    swap(nums, cur++, i);
                }
            }
            
            target++;                               // 모든 탐색이 끝나면 다음 target으로
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
Memory Usage: 37.6 MB, less than 58.53% of Java online submissions for Sort Colors.
*/
