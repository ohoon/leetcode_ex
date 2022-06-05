/*
2293.
Min Max Game
https://leetcode.com/problems/min-max-game/
*/

class Solution {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {         // 사이즈가 1이 되면 재귀 종료
            return nums[0];
        }
        
        int[] newNums = new int[nums.length/2];
        for (int i = 0; i < nums.length / 2; i++) {     // 조건에 따라 newNums 배열을 채워나감
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[2*i], nums[2*i+1]);
            } else {
                newNums[i] = Math.max(nums[2*i], nums[2*i+1]);
            }
        }
        
        return minMaxGame(newNums);         // newNums를 기준으로 재귀 호출
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Min Max Game.
Memory Usage: 44.7 MB, less than 25.00% of Java online submissions for Min Max Game.
*/
