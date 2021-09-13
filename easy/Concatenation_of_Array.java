/*
1929.
Concatenation of Array
https://leetcode.com/problems/concatenation-of-array/
*/

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n*2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nums[i%n];      // 나머지를 이용하여 nums의 요소를 반복해서 
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 59.95% of Java online submissions for Concatenation of Array.
Memory Usage: 39 MB, less than 98.66% of Java online submissions for Concatenation of Array.
*/
