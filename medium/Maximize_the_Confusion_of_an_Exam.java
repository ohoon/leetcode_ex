/*
2024.
Maximize the Confusion of an Exam
https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
*/

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {         // sliding window
        int answer = 0, n = answerKey.length();
        int L = 0, R = 0;
        int tCnt = 0, fCnt = 0;         // 'T', 'F'의 개수
        while (R < n) {
            if (answerKey.charAt(R) == 'T') {
                tCnt++;
            } else {
                fCnt++;
            }

            while (tCnt > k && fCnt > k) {              // 'F' -> 'T' or 'T' -> 'F' 가능한 k를 초과했을 경우 L 포인터를 늘리고 해당하는 문자 cnt 감소
                if (answerKey.charAt(L++) == 'T') {
                    tCnt--;
                } else {
                    fCnt--;
                }
            }

            answer = Math.max(answer, R-L+1);           // 최대 길이 갱신
            R++;
        }

        return answer;
    }
}
