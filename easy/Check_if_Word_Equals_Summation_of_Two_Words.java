/*
1880.
Check if Word Equals Summation of Two Words
https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
*/

class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return wordToInt(firstWord) + wordToInt(secondWord) == wordToInt(targetWord);
    }
    
    public int wordToInt(String word) {             // word를 숫자로 변환해주는 메서드
        int res = 0;
        
        for (int i = 0; i < word.length(); i++) {
            res *= 10;
            res += word.charAt(i) - 'a';
        }
        
        return res;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if Word Equals Summation of Two Words.
Memory Usage: 37.1 MB, less than 85.03% of Java online submissions for Check if Word Equals Summation of Two Words.
*/
