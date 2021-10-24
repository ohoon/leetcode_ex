/*
2047.
Number of Valid Words in a Sentence
https://leetcode.com/problems/number-of-valid-words-in-a-sentence/
*/

class Solution {
    public int countValidWords(String sentence) {
        int answer = 0;
        for (String w : sentence.split(" ")) {
            boolean isWord = true;      // 정상적인 단어인지
            int hyphens = 0;            // 각 w의 -의 개수
            if (w.length() == 0) {
                continue;
            }
            
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (c == ' ') {
                    isWord = false;
                    break;
                }
                
                if (c - '0' >= 0 && c - '0' <= 9) {     // 숫자가 들어있으면 정상적인 word가 아님
                    isWord = false;
                    break;
                }
                
                if (c == '-') {                         // -이 두개거나 알파벳 사이에 존재하지 않으면 정상적인 word가 아님
                    if (++hyphens > 1 || (i == 0 || i == w.length() - 1)) {
                        isWord = false;
                        break;
                    }
                }
                
                if ((c == '!' || c == '.' || c == ',') && (i != w.length() - 1 || (i > 0 && w.charAt(i-1) == '-'))) {       // 마침표들이 마지막에 나오지 않으면 정상적인 word가 아님
                    isWord = false;
                    break;
                }
            }
            
            if (isWord) {
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 7 ms, faster than 42.86% of Java online submissions for Number of Valid Words in a Sentence.
Memory Usage: 41.4 MB, less than 14.29% of Java online submissions for Number of Valid Words in a Sentence.
*/

/*
여담

정규식으로 풀면 코드가 깔끔해진다.
하지만 내가 생각하기엔 정규식을 쓰면 코드의 직관성이 떨어져서 다른 개발자가 봤을 때 코드를 한번에 이해하기 어려울 것이라고 생각이 든다.
그래서 정규식을 쓰지 않고 문제를 풀이하고 싶었다.

*/
