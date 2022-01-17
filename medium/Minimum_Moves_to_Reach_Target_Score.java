/*
2139.
Minimum Moves to Reach Target Score
https://leetcode.com/problems/minimum-moves-to-reach-target-score/
*/

class Solution {
    public int minMoves(int target, int maxDoubles) {       // dp
        if (target == 1) {      // target이 시작점인 1에 위치하면 0 반환
            return 0;
        }
        
        if (maxDoubles == 0) {  // target까지 +1만 하므로 target-1번 move
            return target - 1;
        }
        
        return 1 + (target % 2 == 0 ? minMoves(target / 2, maxDoubles - 1) : minMoves(target - 1, maxDoubles));     // target이 짝수면 double, 홀수면 +1를 선택하는식으로 target을 줄여나감
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Moves to Reach Target Score.
Memory Usage: 37.8 MB, less than 20.00% of Java online submissions for Minimum Moves to Reach Target Score.
*/
