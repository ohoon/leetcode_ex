/*
1701.
Average Waiting Time
https://leetcode.com/problems/average-waiting-time/
*/

class Solution {
    public double averageWaitingTime(int[][] customers) {
        double answer = 0.0;
        int time = 1;
        for (int[] ct : customers) {
            while (time < ct[0]) {      // 아직 고객이 도착하지 않았다면 대기
                time++;
            }
            
            time += ct[1];              // 주문을 받아서 처리
            answer += time - ct[0];     // 소요시간 = 현재 시각 - 고객이 도착한 시각
        }
        
        return answer / customers.length;
    }
}

/*
Runtime: 2 ms, faster than 100.00% of Java online submissions for Average Waiting Time.
Memory Usage: 94.3 MB, less than 67.38% of Java online submissions for Average Waiting Time.
*/
