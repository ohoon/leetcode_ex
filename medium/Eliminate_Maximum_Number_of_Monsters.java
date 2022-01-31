/*
1921.
Eliminate Maximum Number of Monsters
https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
*/

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> pq = new PriorityQueue<>();       // 몬스터들이 도착할 날짜를 담은 우선순위큐
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            pq.offer((double) dist[i] / speed[i]);              // 몬스터들이 기지에 도착하기 까지의 일수 = 거리 / 속도
        }
        
        int answer = 0;
        for (int day = 0; day < n; day++) {         // d-day가 가장 빠른 몬스터부터 poll하여 현재 day와 비교해서 처리
            double d_day = pq.poll();
            if (day >= d_day) {
                return day;
            }
        }
        
        return n;       // 모든 몬스터가 제거됐을 때
    }
}

/*
Runtime: 66 ms, faster than 28.80% of Java online submissions for Eliminate Maximum Number of Monsters.
Memory Usage: 60.2 MB, less than 56.52% of Java online submissions for Eliminate Maximum Number of Monsters.
*/
