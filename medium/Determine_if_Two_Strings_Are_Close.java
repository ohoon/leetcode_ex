/*
1657.
Determine if Two Strings Are Close
https://leetcode.com/problems/determine-if-two-strings-are-close/
*/

class Solution {
    public boolean closeStrings(String word1, String word2) {       // Sorting
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            freq1[c-'a']++;
        }

        for (char c : word2.toCharArray()) {
            freq2[c-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] == 0) || (freq1[i] > 0 && freq2[i] > 0)) {
                continue;
            }

            return false;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == freq2[i]) {
                continue;
            }

            return false;
        }

        return true;
    }
}
