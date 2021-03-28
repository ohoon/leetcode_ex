/*
1217.
Minimum Cost to Move Chips to The Same Position
https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
*/

class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        for (int pos : position) {          // 자리의 홀수, 짝수 개수를 측정
            if (pos % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        
        return Math.min(even, odd);         // 홀수 짝수 중 작은 수만큼 옮기면 됨
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
Memory Usage: 38.1 MB, less than 11.90% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
*/
