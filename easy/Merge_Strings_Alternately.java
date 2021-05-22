/*
1768.
Merge Strings Alternately
https://leetcode.com/problems/merge-strings-alternately/
*/

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while (cur < word1.length() || cur < word2.length()) {
            if (cur < word1.length()) {
                sb.append(word1.charAt(cur));
            }

            if (cur < word2.length()) {
                sb.append(word2.charAt(cur));
            }

            cur++;
        }

        return sb.toString();
    }
}

/*
Runtime: 1 ms, faster than 47.59% of Java online submissions for Merge Strings Alternately.
Memory Usage: 37.2 MB, less than 72.28% of Java online submissions for Merge Strings Alternately.
*/
