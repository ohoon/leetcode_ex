/*
1455.
Check If a Word Occurs As a Prefix of Any Word in a Sentence
https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
*/

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");               // 띄워쓰기를 기준으로 분리
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(searchWord)) {          // 해당 키워드로 시작하면 인덱스 반환
                return i + 1;
            }
        }
        
        return -1;                                          // 발견하지 못할시 -1 반환
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Check If a Word Occurs As a Prefix of Any Word in a Sentence.
Memory Usage: 36.9 MB, less than 57.09% of Java online submissions for Check If a Word Occurs As a Prefix of Any Word in a Sentence.
*/
