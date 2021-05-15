/*
1725.
Number Of Rectangles That Can Form The Largest Square
https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
*/

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int[] answer = {Integer.MIN_VALUE, 0};      // [최댓값, 나온 횟수]
        for (int[] rect : rectangles) {
            int min = Math.min(rect[0], rect[1]);   // 두 변의 길이 중 작은 길이
            if (min > answer[0]) {                  // 최댓값보다 클 경우 answer 갱신
                answer[0] = min;
                answer[1] = 1;
                continue;
            }
            
            if (min == answer[0]) {                 // 최댓값과 같은 경우 나온 횟수 증가
                answer[1]++;
            }
        }
        
        return answer[1];
    }
}

/*
Runtime: 1 ms, faster than 99.65% of Java online submissions for Number Of Rectangles That Can Form The Largest Square.
Memory Usage: 39.5 MB, less than 18.94% of Java online submissions for Number Of Rectangles That Can Form The Largest Square.
*/
