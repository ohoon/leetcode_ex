/*
2124.
Check if All A's Appears Before All B's
https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
*/

class Solution {
    public boolean checkString(String s) {
        boolean b = false;      // b가 나타났는지
        for (char c : s.toCharArray()) {
            if (c == 'a' && b) {
                return false;
            }
            
            if (c == 'b') {
                b = true;
            }
        }
        
        return true;
    }
}

/*
Runtime: 1 ms, faster than 20.00% of Java online submissions for Check if All A's Appears Before All B's.
Memory Usage: 38.7 MB, less than 20.00% of Java online submissions for Check if All A's Appears Before All B's.
*/
