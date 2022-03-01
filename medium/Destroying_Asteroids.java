/*
2126.
Destroying Asteroids
https://leetcode.com/problems/destroying-asteroids/
*/

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long m = mass;
        Arrays.sort(asteroids);
        for (int ast : asteroids) {     // greedy
            if (m < ast) {              // 행성이 소행성 질량보다 작아지면 false
                return false;
            }
            
            m += ast;                   // 행성이 소행성의 질량을 흡수
        }
        
        return true;
    }
}

/*
Runtime: 28 ms, faster than 81.68% of Java online submissions for Destroying Asteroids.
Memory Usage: 101.1 MB, less than 78.77% of Java online submissions for Destroying Asteroids.
*/
