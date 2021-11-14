/*
2068.
Check Whether Two Strings are Almost Equivalent
https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/
*/

class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] alp = new int[26];                // 알파벳별 difference를 나타내는 배열
        for (int i = 0; i < word1.length(); i++) {
            alp[word1.charAt(i)-'a']++;         // word1에서 나온 알파벳에 해당하는 배열 요소는 증가
            alp[word2.charAt(i)-'a']--;         // word2에서 나온 알파벳에 해당하는 배열 요소는 감소
        }

        for (int i = 0; i < 26; i++) {
            if (alp[i] > 3 || alp[i] < -3) {    // almost equivalent하지 않으면 false 반환
                return false;
            }
        }

        return true;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Check Whether Two Strings are Almost Equivalent.
Memory Usage: 37.6 MB, less than 62.50% of Java online submissions for Check Whether Two Strings are Almost Equivalent.
*/
