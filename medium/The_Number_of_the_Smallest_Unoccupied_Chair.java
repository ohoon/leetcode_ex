/*
1942.
The Number of the Smallest Unoccupied Chair
https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
*/

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];     // target의 도착 시간
        PriorityQueue<Integer[]> sitting = new PriorityQueue<>((x, y) -> x[0] - y[0]);      // 현재 앉은 현황을 기록하는 우선순위 큐 (떠나는 시간 기준으로 오름차순 정렬)
        PriorityQueue<Integer> chair = new PriorityQueue<>();       // 잔여 좌석을 관리하는 우선순위 큐
        Arrays.sort(times, (x, y) -> x[0] - y[0]);      // 도착시간을 기준으로 정렬
        for (int i = 0; i < times.length; i++) {
            chair.offer(i);
        }
        
        for (int[] t : times) {
            while (!sitting.isEmpty() && sitting.peek()[0] <= t[0]) {       // 다음 사람이 도착하기 전에 떠나는 사람이 있으면 먼저 의자를 비워줌
                chair.offer(sitting.poll()[1]);
            }
            
            if (t[0] == targetArrival) {        // target이 도착하면 작업을 중단하고 return문으로 이동
                break;
            }
            
            sitting.offer(new Integer[]{t[1], chair.poll()});       // 도착한 사람에게 의자를 할당하고 sitting 큐에 기록
        }
        
        return chair.peek();
    }
}

/*
Runtime: 85 ms, faster than 40.74% of Java online submissions for The Number of the Smallest Unoccupied Chair.
Memory Usage: 73.3 MB, less than 40.74% of Java online submissions for The Number of the Smallest Unoccupied Chair.
*/
