/*
34.
Find First and Last Position of Element in Sorted Array
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        int left = 0, right = nums.length - 1;
        if (nums.length == 0) {
            return answer;
        }
        
        while (left < right) {                  // target들이 시작되는 위치를 찾는 이진 탐색
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        if (nums[left] == target) {
            answer[0] = left;
        } else {                                // target이 발견되지 않으면 [-1, -1] 반환
            return answer;
        }
        
        left = 0;
        right = nums.length - 1;
        while (left < right) {                  // target들이 끝나는 위치를 찾는 이진 탐색
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (left < mid) {
                left = mid;
            } else {
                break;
            }
        }
        
        if (nums[right] == target) {
            answer[1] = right;
        } else if (nums[left] == target) {
            answer[1] = left;
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 44.1 MB, less than 10.64% of Java online submissions for Find First and Last Position of Element in Sorted Array.
*/

/*
여담

어떻게 풀어내긴 했지만 코드도 많이 더러운 것 같고, 실패 시도 횟수도 많아서 만족스럽게 풀이하진 못했다.
이진탐색이 어떻게 작동하는지 완벽하게 이해하기에 좋은 문제인 것 같다.
다시 풀어서 이번엔 깔끔한 코드를 짜보자.

*/
