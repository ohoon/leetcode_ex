/*
1470.
Shuffle the Array
https://leetcode.com/problems/shuffle-the-array/
*/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[nums.length];
        int curX = 0;
        int curY = n;
        for (int i = 0; i < answer.length; i++) {
            if (i % 2 == 0) {               // 짝수 인덱스엔 앞부분의 요소를
                answer[i] = nums[curX++];
            } else {                        // 홀수 인덱스엔 뒷부분의 요소를 대입
                answer[i] = nums[curY++];
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Shuffle the Array.
Memory Usage: 38.6 MB, less than 98.46% of Java online submissions for Shuffle the Array.
*/
