/*
1962.
Remove Stones to Minimize the Total
https://leetcode.com/problems/remove-stones-to-minimize-the-total/
*/

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>((x, y) -> Double.compare(y, x));     // 내림차순으로 정렬되는 우선순위 큐
        for (int p : piles) {       // 모든 pile을 우선순위 큐에 삽입
            pq.offer((double) p);
        }
        
        for (int i = 0; i < k; i++) {   // 우선순위 큐에서 k번 poll해서 작업
            if (pq.peek() == 1) {       // 우선순위 큐에서 가장 큰 수가 1인 경우, 반으로 나눠도 1이 되므로 일찍 종료
                break;
            }
            
            double p = pq.poll();
            pq.offer(Math.ceil((p / 2)));       // p를 반으로 나눈 것을 올림해서 우선순위 큐에 다시 삽입
        }
        
        double answer = 0;
        while (!pq.isEmpty()) {     // 우선순위 큐에 있는 모든 pile의 값을 answer에 더해줌
            answer += pq.poll();
        }
        
        return (int) answer;
    }
}

/*
Runtime: 743 ms, faster than 54.31% of Java online submissions for Remove Stones to Minimize the Total.
Memory Usage: 61.5 MB, less than 77.16% of Java online submissions for Remove Stones to Minimize the Total.
*/
