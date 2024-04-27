/*
2716.
Minimize String Length
https://leetcode.com/problems/minimize-string-length/
*/

class Solution {
    public int minimizedStringLength(String s) {
        boolean[] alpha = new boolean[26];
        for (char ch : s.toCharArray()) {
            alpha[ch-'a'] = true;
        }

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (alpha[i]) {
                answer++;
            }
        }

        return answer;
    }
}
