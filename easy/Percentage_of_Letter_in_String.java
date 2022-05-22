/*
2278.
Percentage of Letter in String
https://leetcode.com/problems/percentage-of-letter-in-string/
*/

class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char c : s.toCharArray()) {        // letter의 빈도수 계산
            if (c == letter) {
                count++;
            }
        }
        
        return count * 100 / s.length();
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Percentage of Letter in String.
Memory Usage: 42.1 MB, less than 50.00% of Java online submissions for Percentage of Letter in String.
*/
