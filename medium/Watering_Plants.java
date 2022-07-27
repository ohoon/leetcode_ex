/*
2079.
Watering Plants
https://leetcode.com/problems/watering-plants/
*/

class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int answer = 0;
        int water = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (water < plants[i]) {
                water = capacity;
                answer += 2 * i;
            }
            
            water -= plants[i];
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Watering Plants.
Memory Usage: 41.5 MB, less than 96.20% of Java online submissions for Watering Plants.
*/
