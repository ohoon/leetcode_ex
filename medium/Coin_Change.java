/*
322.
Coin Change
https://leetcode.com/problems/coin-change/
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        Deque<Integer> deq = new LinkedList<>();        // 너비 우선 탐색용 덱
        boolean[] visited = new boolean[amount+1];      // 재탐색 방지용 불린 배열
        int count = 0;
        deq.offer(0);
        while (!deq.isEmpty()) {
            count++;
            int size = deq.size();
            for (int i = 0; i < size; i++) {
                int p = deq.poll();
                for (int c : coins) {       // p에서 각각의 코인을 더해서 deq에 삽입
                    int res = p + c;
                    if (res > amount || visited[res]) {     // 다음 코인 값이 amount를 넘거나 이미 탐색했던 값이라면 덱에 삽입할 필요 X
                        continue;
                    }
                    
                    if (res == amount) {        // 가장 빠르게 amount를 완성했을 때 count 반환하고 종료
                        return count;
                    }
                    
                    deq.offer(res);
                    visited[res] = true;        // 탐색한 값은 visited에 기록
                }
            }
        }
        
        return -1;      // amount로 맞게 떨어지는 코인 조합이 없으면 -1
    }
}

/*
Runtime: 44 ms, faster than 26.67% of Java online submissions for Coin Change.
Memory Usage: 55.8 MB, less than 15.17% of Java online submissions for Coin Change.
*/
