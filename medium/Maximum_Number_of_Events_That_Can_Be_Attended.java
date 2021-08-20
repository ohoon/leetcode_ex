/*
1353.
Maximum Number of Events That Can Be Attended
https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
*/

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (x, y) -> x[0] - y[0]);         // start day를 기준으로 오름차순 정렬
        int answer = 0;
        int i = 0, n = events.length;
        int day = events[0][0];                             // 현재 day
        PriorityQueue<Integer> heapq = new PriorityQueue<>();       // 현재 day로부터 end day가 가까운 것부터 처리하기 위한 우선순위 큐
        while (i < n || !heapq.isEmpty()) {
            while (!heapq.isEmpty() && heapq.peek() < day) {        // 이미 만료되버린 event는 큐에서 제거
                heapq.poll();
            }
            
            while (i < n && day >= events[i][0]) {                  // 현재 day에 할당 가능한 event는 큐에 추가
                heapq.add(events[i++][1]);
            }
            
            if (!heapq.isEmpty()) {                                 // 큐에서 가장 급한 event를 하나 poll하여 처리
                heapq.poll();
                answer++;
            }
            
            day++;
        }
        
        return answer;
    }
}

/*
Runtime: 60 ms, faster than 94.43% of Java online submissions for Maximum Number of Events That Can Be Attended.
Memory Usage: 84.4 MB, less than 69.02% of Java online submissions for Maximum Number of Events That Can Be Attended.
*/

/*
여담

정렬 comparable만 손보면 쉽게 풀릴 줄 알았는데 생각보다 쉽지 않았다.
각각의 이벤트의 우선순위를 어떻게 계산해서 처리해야 할지 굉장히 오래 고민했고,
우선순위 큐를 이용하면 이 복잡한 상황은 해결할 수 있을 것 같아서 써봤고, 실제로 해결됐다.
잘 돌아가서 다행이지만 생각하고 구현하는데 시간을 너무 써서 잘 풀었다고 생각되진 않는다.

*/
