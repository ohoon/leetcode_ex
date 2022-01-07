/*
1451.
Rearrange Words in a Sentence
https://leetcode.com/problems/rearrange-words-in-a-sentence/
*/

class Solution {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");     // text를 word들로 분해
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());      // word 길이를 기준으로 오름차순 정렬
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);      // capitalize
        return String.join(" ", words);
    }
}

/*
Runtime: 41 ms, faster than 35.00% of Java online submissions for Rearrange Words in a Sentence.
Memory Usage: 52.1 MB, less than 20.36% of Java online submissions for Rearrange Words in a Sentence.
*/
