/*
1509.
Minimum Difference Between Largest and Smallest Value in Three Moves
https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
*/

class Solution {
    public int minDifference(int[] nums) {      // sliding window
        int n = nums.length;
        if (n <= 3) {           // 개수가 3개 이하면 모든 요소를 같게 만들면 됨
            return 0;
        }
        
        Arrays.sort(nums);
        int answer = Integer.MAX_VALUE;
        int size = n-3;     // window 크기
        for (int i = 0; i <= n-size; i++) {
            answer = Math.min(answer, nums[i+size-1] - nums[i]);        // window 안의 첫 요소와 마지막 요소의 차이만 계산하면 됨
        }
        
        return answer;
    }
}

/*
Runtime: 23 ms, faster than 34.49% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
Memory Usage: 65.8 MB, less than 49.55% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
*/
