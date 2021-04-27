/*
1550.
Three Consecutive Odds
https://leetcode.com/problems/three-consecutive-odds/
*/

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {       // 3개 미만이면 false 반환
            return false;
        }
        
        for (int i = 2; i < arr.length; i++) {
            if ((arr[i-2] * arr[i-1] * arr[i]) % 2 > 0) {       // 연속적인 3개의 홀수가 나타나면 true 반환
                return true;
            }
        }
        
        return false;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Three Consecutive Odds.
Memory Usage: 38.5 MB, less than 58.94% of Java online submissions for Three Consecutive Odds.
*/
