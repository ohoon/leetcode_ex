/*
11.
Container With Most Water
https://leetcode.com/problems/container-with-most-water/
*/

class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            answer = Math.max(answer, Math.min(height[left], height[right]) * (right - left));      // 두 높이의 최소값과 거리를 곱한 넓이로 answer 값 갱신
            if (height[left] > height[right]) {         // 두 높이 중 작은 쪽의 커서를 이동
                right--;
            } else {
                left++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 82.60% of Java online submissions for Container With Most Water.
Memory Usage: 52.8 MB, less than 38.33% of Java online submissions for Container With Most Water.
*/
