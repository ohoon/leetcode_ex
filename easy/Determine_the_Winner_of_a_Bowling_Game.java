/*
2660.
Determine the Winner of a Bowling Game
https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/
*/

class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int point1 = 0, point2 = 0;
        int prev1 = Integer.MIN_VALUE, prev2 = Integer.MIN_VALUE;
        for (int i = 0; i < player1.length; i++) {
            point1 += (prev1 < i-2 ? player1[i] : 2*player1[i]);
            point2 += (prev2 < i-2 ? player2[i] : 2*player2[i]);
            if (player1[i] == 10) {
                prev1 = i;
            }

            if (player2[i] == 10) {
                prev2 = i;
            }
        }
        
        return (point1 > point2 ? 1 : (point1 < point2 ? 2 : 0));
    }
}
