/*
2185.
Counting Words With a Given Prefix
https://leetcode.com/problems/counting-words-with-a-given-prefix/
*/

class Solution {
    public int prefixCount(String[] words, String pref) {
        int answer = 0;
        int n = pref.length();
        for (String word : words) {
            if (word.length() < n) {        // word.startsWith()와 같은 방식
                continue;
            }
            
            if (pref.equals(word.substring(0, n))) {
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 83.33% of Java online submissions for Counting Words With a Given Prefix.
Memory Usage: 42.8 MB, less than 83.33% of Java online submissions for Counting Words With a Given Prefix.
*/
