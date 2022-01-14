/*
1882.
Process Tasks Using Servers
https://leetcode.com/problems/process-tasks-using-servers/
*/

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] answer = new int[tasks.length];
        PriorityQueue<int[]> serverQueue = new PriorityQueue<>((x, y) -> {      // 현재 사용 가능한 server의 우선순위 큐 (가중치 > 인덱스 순으로 오름차순)
            if (x[1] != y[1]) {
                return x[1] - y[1];
            }
            
            return x[0] - y[0];
        });
            
        PriorityQueue<int[]> workQueue = new PriorityQueue<>((x, y) -> {        // 일하고 있는 server의 우선순위 큐 (일이 끝나는 시간 > 가중치 > 인덱스 순으로 오름차순)
            if (x[2] != y[2]) {
                return x[2] - y[2];
            }
            
            if (x[1] != y[1]) {
                return x[1] - y[1];
            }
            
            return x[0] - y[0];
        });
        
        for (int i = 0; i < servers.length; i++) {          // serverQueue를 초기화
            serverQueue.offer(new int[]{i, servers[i]});
        }
        
        for (int i = 0; i < tasks.length; i++) {
            while (!workQueue.isEmpty() && workQueue.peek()[2] <= i) {          // 일이 끝난 모든 server를 serverQueue에 offer
                int r = workQueue.poll()[0];
                serverQueue.offer(new int[]{r, servers[r]});
            }

            if (serverQueue.isEmpty()) {            // 현재 사용 가능한 server가 없으면 가장 빨리 일이 끝나는 server를 하나 가져와서 예약 할당
                int[] w = workQueue.poll();
                workQueue.offer(new int[]{w[0], w[1], w[2] + tasks[i]});
                answer[i] = w[0];
            } else {                                // 현재 사용 가능한 server가 있으면 해당 server에 일을 할당
                int[] s = serverQueue.poll();
                workQueue.offer(new int[]{s[0], s[1], i + tasks[i]});
                answer[i] = s[0];
            }
            
        }
        
        return answer;
    }
}

/*
Runtime: 428 ms, faster than 31.92% of Java online submissions for Process Tasks Using Servers.
Memory Usage: 159.4 MB, less than 30.89% of Java online submissions for Process Tasks Using Servers.
*/

/*
여담

문제를 풀이하는 과정 자체는 어렵지 않았다.
우선순위 큐를 2개 사용해서 풀면되는 문제인데, 문제에서 명시된 규칙을 잘못 이해해서 푸는데 시간이 많이 걸렸던 것 같다.

*/
