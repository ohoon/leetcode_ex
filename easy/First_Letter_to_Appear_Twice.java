/*
2351.
First Letter to Appear Twice
https://leetcode.com/problems/first-letter-to-appear-twice/
*/

class Solution {
    public char repeatedCharacter(String s) {
        boolean[] repeated = new boolean[26];
        for (char c : s.toCharArray()) {
            if (repeated[c-'a']) {
                return c;
            }
            
            repeated[c-'a'] = true;
        }
        
        return '\0';
    }
}

/*
Runtime: 1 ms, faster than 25.00% of Java online submissions for First Letter to Appear Twice.
Memory Usage: 42.1 MB, less than 25.00% of Java online submissions for First Letter to Appear Twice.
*/
