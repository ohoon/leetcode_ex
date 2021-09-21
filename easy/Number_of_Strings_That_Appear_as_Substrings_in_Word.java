/*
1967.
Number of Strings That Appear as Substrings in Word
https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
*/

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int answer = 0;
        for (String p : patterns) {
            if (word.contains(p)) {     // 각 패턴이 word에 속하면 answer 증가
                answer++;
}
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 29.89% of Java online submissions for Number of Strings That Appear as Substrings in Word.
Memory Usage: 39.6 MB, less than 19.75% of Java online submissions for Number of Strings That Appear as Substrings in Word.
*/
