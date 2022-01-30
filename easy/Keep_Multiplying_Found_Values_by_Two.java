/*
2154.
Keep Multiplying Found Values by Two
https://leetcode.com/problems/keep-multiplying-found-values-by-two/
*/

class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] used = new boolean[1001];     // nums에 포함된 숫자들을 나타내기 위한 배열
        for (int num : nums) {
            used[num] = true;
        }
        
        while (original < 1001) {               // original이 used 배열에 있을때까지 2배씩 늘림
            if (!used[original]) {      
                break;
            }
            
            original *= 2;
        }
        
        return original;
    }
}

/*
Runtime: 2 ms, faster than 80.00% of Java online submissions for Keep Multiplying Found Values by Two.
Memory Usage: 44 MB, less than 20.00% of Java online submissions for Keep Multiplying Found Values by Two.
*/
