/*
1884.
Egg Drop With 2 Eggs and N Floors
https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
*/

class Solution {                        // math
    public int twoEggDrop(int n) {
        return (int) Math.ceil((Math.sqrt(1 + 8*n) - 1) / 2.0);     // 근의 공식 활용
    }
}

/*
Runtime: 1 ms, faster than 82.60% of Java online submissions for Egg Drop With 2 Eggs and N Floors.
Memory Usage: 41.3 MB, less than 57.96% of Java online submissions for Egg Drop With 2 Eggs and N Floors.
*/
