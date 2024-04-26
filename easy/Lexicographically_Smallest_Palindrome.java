/*
2697.
Lexicographically Smallest Palindrome
https://leetcode.com/problems/lexicographically-smallest-palindrome/
*/

class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < chars.length/2; i++) {
            chars[i] = (char) Math.min(chars[i], chars[len-i-1]);
            chars[len-i-1] = (char) Math.min(chars[i], chars[len-i-1]);
        }

        return new String(chars);
    }
}
