/*
1652.
Defuse the Bomb
https://leetcode.com/problems/defuse-the-bomb/
*/

class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] answer = new int[code.length];
        if (k == 0) {
            return answer;
        }

        int dir = 1;        // k가 양수면 1씩 감소
        if (k < 0) {        // k가 음수면 1씩 증가
            dir = -1;
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = k; j != 0; j -= dir) {         // k부터 +-1까지 i 인덱스에 더하여 answer에 대입
                int cur = i + j;
                while (cur < 0) {                       // cur이 음수가 되면 code의 길이를 더해주어 나머지 연산 오류 방지
                    cur += code.length;
                }

                answer[i] += code[cur % code.length];   // 최종 인덱스는 code를 사이클로 순환
            }
        }

        return answer;
    }
}

/*
Runtime: 2 ms, faster than 44.29% of Java online submissions for Defuse the Bomb.
Memory Usage: 39.2 MB, less than 36.94% of Java online submissions for Defuse the Bomb.
*/
