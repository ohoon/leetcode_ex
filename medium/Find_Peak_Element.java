/*
162.
Find Peak Element
https://leetcode.com/problems/find-peak-element/
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid+1]) {      // 오르막인 경우엔 peak가 mid 다음에 있을 것이므로 left를 mid+1로 이동
                left = mid + 1;
            } else {                            // 내리막인 경우에는 mid가 peak일 가능성이 있으므로 right를 mid 위치로 이동
                right = mid;
            }
        }
        
        return left;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
Memory Usage: 40 MB, less than 8.70% of Java online submissions for Find Peak Element.
*/
