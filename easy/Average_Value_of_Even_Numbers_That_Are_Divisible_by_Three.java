/*
2455.
Average Value of Even Numbers That Are Divisible by Three
https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/
*/

class Solution {
    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int n : nums) {
            if (n % 2 != 0 || n % 3 != 0) {
                continue;
            }
            
            sum += n;
            count++;
        }
        
        return count > 0 ? sum / count : 0;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Average Value of Even Numbers That Are Divisible by Three.
Memory Usage: 42 MB, less than 100.00% of Java online submissions for Average Value of Even Numbers That Are Divisible by Three.
*/
