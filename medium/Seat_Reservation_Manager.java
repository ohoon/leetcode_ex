/*
1845.
Seat Reservation Manager
https://leetcode.com/problems/seat-reservation-manager/
*/

class SeatManager {

    private PriorityQueue<Integer> pq;      // 시트 번호가 빠른 순으로 예약하기 위해서 우선순위 큐 사용
    
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {      // 사용 가능한 시트들을 우선순위 큐에 등록
            pq.offer(i);
        }
    }
    
    public int reserve() {                  // 사용 가능한 시트들에서 가장 빠른 번호의 시트를 우선순위 큐에서 제거하고 반환
        return pq.poll();
    }
    
    public void unreserve(int seatNumber) { // 우선순위 큐에 해당 시트 번호를 재등록
        pq.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */

/*
Runtime: 85 ms, faster than 68.92% of Java online submissions for Seat Reservation Manager.
Memory Usage: 82.9 MB, less than 59.38% of Java online submissions for Seat Reservation Manager.
*/
