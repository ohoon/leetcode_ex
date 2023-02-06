/*
2558.
Take Gifts From the Richest Pile
https://leetcode.com/problems/take-gifts-from-the-richest-pile/
*/

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));      // 내림차순 우선순위큐
        for (int gift : gifts) {
            pq.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            int next = (int) Math.pow(pq.poll(), 0.5);      // 루트값 구하기 위함
            pq.offer(next);     // 
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        
        return answer;
    }
}
