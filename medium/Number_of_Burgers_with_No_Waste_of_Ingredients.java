/*
1276.
Number of Burgers with No Waste of Ingredients
https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
*/

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices == 0 && cheeseSlices == 0) {       // jumbo = 0, small = 0일 때 조건 성립
            return Arrays.asList(0, 0);
        }
        
        int L = 0, R = cheeseSlices;
        while (L < R) {         // 2진 탐색
            int jumbo = (L + R) / 2;
            int small = cheeseSlices - jumbo;
            int tomatoNeed = 4 * jumbo + 2 * small;
            if (tomatoNeed > tomatoSlices) {
                R = jumbo;
                continue;
            }
            
            if (tomatoNeed < tomatoSlices) {
                L = jumbo + 1;
                continue;
            }
            
            return Arrays.asList(jumbo, small);     // 필요한 토마토의 개수와 준비된 토마토 개수가 같으면 현재 jumbo, small로 반환
        }
        
        return new ArrayList<>();
    }
}

/*
Runtime: 5 ms, faster than 22.56% of Java online submissions for Number of Burgers with No Waste of Ingredients.
Memory Usage: 43.2 MB, less than 6.77% of Java online submissions for Number of Burgers with No Waste of Ingredients.
*/
