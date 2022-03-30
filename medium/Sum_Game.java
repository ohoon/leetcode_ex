/*
1927.
Sum Game
https://leetcode.com/problems/sum-game/
*/

class Solution {
    public boolean sumGame(String num) {
        int Lsum = 0, Rsum = 0;         // 왼쪽과 오른쪽 숫자들의 합
        int Lempty = 0, Rempty = 0;     // 왼쪽과 오른쪽 ?의 개수
        int n = num.length();
        for (int i = 0; i < n; i++) {       // sum은 합을, empty는 ?의 개수를 구함
            if (i < n/2) {
                if (num.charAt(i) == '?') {
                    Lempty++;
                } else {
                    Lsum += num.charAt(i) - '0';
                }
            } else {
                if (num.charAt(i) == '?') {
                    Rempty++;
                } else {
                    Rsum += num.charAt(i) - '0';
                }
            }
        }
        
        if ((Lempty + Rempty) % 2 == 1) {       // empty의 개수가 홀수개라면 먼저 시작하는 alice가 마지막 ?을 선택하므로 무조건 승리하게 됨
            return true;
        }
        
        int diff = Math.abs(Rempty - Lempty) / 2;       // alice 혹은 bob 어느 한쪽이 9를 더 많이 선택하는 정도
        if (Lempty < Rempty) {
            Rsum += 9 * diff;
        } else {
            Lsum += 9 * diff;
        }
        
        return Lsum != Rsum;
    }
}

/*
Runtime: 12 ms, faster than 65.45% of Java online submissions for Sum Game.
Memory Usage: 50.6 MB, less than 27.27% of Java online submissions for Sum Game.
*/
