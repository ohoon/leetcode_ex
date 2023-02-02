/*
2483.
Minimum Penalty for a Shop
https://leetcode.com/problems/minimum-penalty-for-a-shop/
*/

class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] open = new int[n+1];      // 항상 가게가 열려있다 가정하에 패널티 누적값
        int[] close = new int[n+1];     // 항상 가게가 닫혀있다 가정하에 패널티 누적값
        for (int i = 0; i < n; i++) {
            open[i+1] = open[i] + (customers.charAt(i) == 'Y' ? 0 : 1);
            close[i+1] = close[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int answer = -1, minPenalty = n;
        for (int i = 0; i < n+1; i++) {
            int penalty = open[i] + close[n] - close[i];        // 해당 시각을 기준으로 패널티 계산
            if (penalty >= minPenalty) {
                continue;
            }

            answer = i;
            minPenalty = penalty;
        }

        return answer;
    }
}
