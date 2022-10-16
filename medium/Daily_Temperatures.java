/*
739.
Daily Temperatures
https://leetcode.com/problems/daily-temperatures/
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);       // 기온을 기준으로 오름차순 정렬 우선순위 큐
        for (int i = 0; i < temperatures.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < temperatures[i]) {       // 현재 기온보다 낮은 기온인 것은 poll해서 인덱스 차이값을 answer에 기록
                Integer[] p = pq.poll();
                answer[p[1]] = i - p[1];
            }
            
            pq.offer(new Integer[]{temperatures[i], i});        // 현재 기온과 인덱스를 우선순위 큐에 
        }
        
        return answer;
    }
}

/*
Runtime: 231 ms, faster than 16.87% of Java online submissions for Daily Temperatures.
Memory Usage: 129.4 MB, less than 56.67% of Java online submissions for Daily Temperatures.
*/
