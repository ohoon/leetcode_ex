/*
2016.
Maximum Difference Between Increasing Elements
https://leetcode.com/problems/maximum-difference-between-increasing-elements/
*/

class Solution {
    public int maximumDifference(int[] nums) {
        int answer = -1;
        int min = nums[0];              // 저점
        for (int i = 1; i < nums.length; i++) {
            if (min >= nums[i]) {       // 현재 가리키는 요소가 min 이하면 min 갱신하고 다음 요소로 이동
                min = nums[i];
                continue;
            }
            
            answer = Math.max(answer, nums[i] - min);       // 현재 가리키는 요소와 min 차이를 구해서 answer와 비교하여 갱신
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Difference Between Increasing Elements.
Memory Usage: 38.8 MB, less than 83.33% of Java online submissions for Maximum Difference Between Increasing Elements.
*/
