/*
2114.
Maximum Number of Words Found in Sentences
https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
*/

class Solution {
    public int mostWordsFound(String[] sentences) {
        int answer = 0;
        for (String s : sentences) {
            answer = Math.max(answer, s.split(" ").length);     // 단어 길이의 최대값 갱신
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 100.00% of Java online submissions for Maximum Number of Words Found in Sentences.
Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Maximum Number of Words Found in Sentences.
*/
