/*
2739.
Total Distance Traveled
https://leetcode.com/problems/total-distance-traveled/
*/

class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int m = mainTank, addTank = 0;
        while (m >= 5 && additionalTank > 0) {
            int addAmount = Math.min(m/5, additionalTank);
            addTank += addAmount;
            additionalTank -= addAmount;
            m = m/5 + m%5;
        }
        
        return (mainTank + addTank) * 10;
    }
}
