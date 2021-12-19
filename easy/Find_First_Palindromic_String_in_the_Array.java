/*
2108.
Find First Palindromic String in the Array
https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
*/

class Solution {
    private boolean isPalindromic(String word) {            // 단어가 palindromic한지 확인하는 함수
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len-i-1)) {
                return false;
            }
        }

        return true;
    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {         // 각 단어를 하나씩 탐색
            if (isPalindromic(word)) {
                return word;
            }
        }

        return new String();
    }
}

/*
Runtime: 2 ms, faster than 42.86% of Java online submissions for Find First Palindromic String in the Array.
Memory Usage: 39.3 MB, less than 28.57% of Java online submissions for Find First Palindromic String in the Array.
*/
