/*
2682.
Find the Losers of the Circular Game
https://leetcode.com/problems/find-the-losers-of-the-circular-game/
*/

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] recieved = new boolean[n];
        int cur = 0, turn = 1;
        while (true) {
            if (recieved[cur]) {
                break;
            }

            recieved[cur] = true;
            cur = (cur + k*turn++) % n;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (recieved[i]) {
                continue;
            }
            
            answer.add(i+1);
        }

        return answer.stream().mapToInt(v->v).toArray();
    }
}
