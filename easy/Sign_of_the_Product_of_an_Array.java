/*
1822.
Sign of the Product of an Array
https://leetcode.com/problems/sign-of-the-product-of-an-array/
*/

class Solution {
    public int arraySign(int[] nums) {
        int answer = 1;
        for (int num : nums) {
            if (num < 0) {
                answer *= -1;
            } else if (num == 0) {
                return 0;
            }
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Sign of the Product of an Array.
Memory Usage: 41.3 MB, less than 8.91% of Java online submissions for Sign of the Product of an Array.
*/
