/*
1839.
Longest Substring Of All Vowels in Order
https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/
*/

class Solution {
    public int longestBeautifulSubstring(String word) {
        int answer = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int curr = 0, length = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (i > 0 && c == word.charAt(i-1) && length > 0) {     // aaaaeeiiiiiooouu처럼 연속적으로 나오는 경우에는 length만 늘려주고 패스
                length++;
                continue;
            }
            
            if (curr == vowels.length) {                            // aeiou 모두 나왔을 경우
                answer = Math.max(answer, length);
                if (c == 'a') {     // aeiou 다음 a로 시작할 경우 curr와 length를 1부터 시작
                    curr = 1;
                    length = 1;
                } else {            // 그 외의 경우에는 0으로 초기화
                    curr = 0;
                    length = 0;
                }
                
                continue;
            }
            
            if (c != vowels[curr]) {        // aeiou 순서에 맞지 않는 알파벳이 나온 경우
                if (c == 'a') {
                    curr = 1;
                    length = 1;
                } else {
                    curr = 0;
                    length = 0;
                }
                
                continue;
            }
            
            length++;                   // aeiou 순서에 맞는 알파벳이 나온 경우
            curr++;
        }
        
        return curr == vowels.length ? Math.max(answer, length) : answer;
    }
}

/*
Runtime: 40 ms, faster than 46.26% of Java online submissions for Longest Substring Of All Vowels in Order.
Memory Usage: 56.6 MB, less than 6.07% of Java online submissions for Longest Substring Of All Vowels in Order.
*/

/*
여담

문제를 어찌저찌 풀고나서 다시보니 코드가 너무 더럽고 이해하기 힘들 것 같다.
주어지는 문자열 전제 조건이 aeiou 모음만 넣는다고 하니 굳이 vowels 배열을 해서 풀이할 것도 아닌 것 같다.
마음에 썩 들진 않지만 결과는 다행히 잘 나와서 십년감수다.
*/
