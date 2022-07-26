/*
2347.
Best Poker Hand
https://leetcode.com/problems/best-poker-hand/
*/

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        if (suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4]) {
            return "Flush";
        }
        
        int[] count = new int[14];
        for (int r : ranks) {
            count[r]++;
        }
        
        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }
        
        return (max >= 3 ? "Three of a Kind" : (max == 2 ? "Pair" : "High Card"));
    }
}

/*
Runtime: 1 ms, faster than 76.92% of Java online submissions for Best Poker Hand.
Memory Usage: 42 MB, less than 30.77% of Java online submissions for Best Poker Hand.
*/
