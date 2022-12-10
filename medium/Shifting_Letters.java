/*
848.
Shifting Letters
https://leetcode.com/problems/shifting-letters/
*/

class Solution {
    private char shift(char ch) {       // 다음 알파벳을 반환하는 메서드
        return ch == 'z' ? 'a' : (char) (ch + 1);
    }

    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        shifts[n-1] %= 26;
        for (int i = n-2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i+1]) % 26;     // 26번 shift하면 자기 자신이 되므로 26으로 나머지계산
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            for (int j = 0; j < shifts[i]; j++) {
                ch = shift(ch);
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}
