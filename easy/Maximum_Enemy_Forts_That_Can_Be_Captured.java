/*
2511.
Maximum Enemy Forts That Can Be Captured
https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/
*/

class Solution {
    public int captureForts(int[] forts) {
        int answer = 0, army = -1, empty = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                if (empty > army) {
                    answer = Math.max(answer, i-empty-1);
                }

                army = i;
                continue;
            }

            if (forts[i] == -1) {
                if (army > empty) {
                    answer = Math.max(answer, i-army-1);
                }

                empty = i;
                continue;
            }
        }

        return answer;
    }
}
