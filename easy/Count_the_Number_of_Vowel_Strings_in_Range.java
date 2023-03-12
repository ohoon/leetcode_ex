/*
2586.
Count the Number of Vowel Strings in Range
https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
*/

class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int vowelStrings(String[] words, int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                answer++;
            }
        }

        return answer;
    }
}
