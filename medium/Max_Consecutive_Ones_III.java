/*
1004.
Max Consecutive Ones III
https://leetcode.com/problems/max-consecutive-ones-iii/
*/

class Solution {
    public int longestOnes(int[] nums, int k) {         // sliding window
        int answer = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {                     // flip이 필요할 때
                while (k == 0) {                    // k가 0이면 prev 인덱스를 +1씩 땡김
                    if (nums[prev++] == 0) {
                        k++;
                    }
                }
                
                k--;        // k를 소모해서 flip
            }
            
            answer = Math.max(answer, i - prev + 1);
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 93.15% of Java online submissions for Max Consecutive Ones III.
Memory Usage: 42.9 MB, less than 98.65% of Java online submissions for Max Consecutive Ones III.
*/
