/*
1859.
Sorting the Sentence
https://leetcode.com/problems/sorting-the-sentence/
*/

class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] answer = new String[arr.length];
        for (String str : arr) {
            answer[str.charAt(str.length() - 1) - '1'] = str.substring(0, str.length() - 1);    // 뒤에 숫자에 적힌 인덱스 위치에 단어 저장
        }

        return String.join(" ", answer);
    }
}

/*
Runtime: 2 ms, faster than 51.97% of Java online submissions for Sorting the Sentence.
Memory Usage: 39 MB, less than 18.39% of Java online submissions for Sorting the Sentence.
*/
