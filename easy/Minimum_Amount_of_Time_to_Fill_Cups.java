/*
2335.
Minimum Amount of Time to Fill Cups
https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
*/

class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));      // 내림차순 기준 우선순위 큐
        for (int n : amount) {
            pq.offer(n);
        }
        
        int answer = 0;
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {               // 마지막에 남은 컵의 내용물을 모두 fill up
                return answer + pq.poll();
            }
            
            int first = pq.poll();              // 가장 양이 많은 두 컵씩 fill up
            int second = pq.poll();
            if (first > 1) {
                pq.offer(first - 1);
            }
            
            if (second > 1) {
                pq.offer(second - 1);
            }
            
            if (first == 0 && second == 0) {
                continue;
            }
            
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 40.00% of Java online submissions for Minimum Amount of Time to Fill Cups.
Memory Usage: 41.5 MB, less than 70.00% of Java online submissions for Minimum Amount of Time to Fill Cups.
*/
