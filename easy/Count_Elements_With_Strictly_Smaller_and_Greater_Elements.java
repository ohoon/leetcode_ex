/*
2148.
Count Elements With Strictly Smaller and Greater Elements
https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
*/

class Solution {
    public int countElements(int[] nums) {
        int L = 0, R = nums.length - 1;     // L = 최소값의 인덱스, R = 최대값의 인덱스
        Arrays.sort(nums);                  // 오름차순 정렬
        while (L < R) {
            if (nums[L] != nums[L+1] && nums[R] != nums[R-1]) {     // 더 이상 L과 R을 옮길 수 없으면 R과 L 사이의 요소 개수를 반환
                return R - L - 1;
            }
            
            if (nums[L] == nums[L+1]) {
                L++;
            }
            
            if (nums[R] == nums[R-1]) {
                R--;
            }
        }
        
        return 0;
    }
}

/*
Runtime: 2 ms, faster than 25.00% of Java online submissions for Count Elements With Strictly Smaller and Greater Elements .
Memory Usage: 39.3 MB, less than 12.50% of Java online submissions for Count Elements With Strictly Smaller and Greater Elements .
*/
