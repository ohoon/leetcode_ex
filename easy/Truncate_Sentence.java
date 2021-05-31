/*
1816.
Truncate Sentence
https://leetcode.com/problems/truncate-sentence/
*/

class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {               // 공백이 나오면
                if (--k == 0) {                     // k 1회 감소. k가 0이 되면 for문 break
                    break;
                }
            }
            
            sb.append(s.charAt(i));                 // break되기 까지의 모든 문자 StringBuilder에 저장
        }
        
        return sb.toString();
    }
}

/*
Runtime: 1 ms, faster than 76.21% of Java online submissions for Truncate Sentence.
Memory Usage: 37.4 MB, less than 74.38% of Java online submissions for Truncate Sentence.
*/
