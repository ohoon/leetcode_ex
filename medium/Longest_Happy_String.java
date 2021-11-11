/*
1405.
Longest Happy String
https://leetcode.com/problems/longest-happy-string/
*/

class Solution {
    private void initQueue(PriorityQueue<int[]> pq, int a, int b, int c) {      // 우선순위큐에 각 문자와 최대 갯수 배열을 삽입하는 함수
        if (a > 0) {
            pq.offer(new int[]{'a', a});
        }
        
        if (b > 0) {
            pq.offer(new int[]{'b', b});
        }
        
        if (c > 0) {
            pq.offer(new int[]{'c', c});
        }
    }
    
    private void process(StringBuilder sb, PriorityQueue<int[]> pq, int[] p) {      // StringBuilder에 해당 문자를 삽입하고 우선순위큐에 다시 삽입하는 함수
        sb.append((char) p[0]);
        if (--p[1] > 0) {
            pq.offer(p);
        }
    }
    
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]);      // 우선순위가 각 문자의 최대 갯수인 우선순위큐 정의
        initQueue(pq, a, b, c);
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int strSize = sb.length();
            if (strSize >= 2 && sb.charAt(strSize-1) == (char) p[0] && sb.charAt(strSize-2) == (char) p[0]) {   // poll해서 가져온 문자가 3번째로 연속되는 문자일 경우
                if (pq.isEmpty()) {     // 대신 넣을 문자가 없는 경우 while문 종료
                    break;
                }
                
                process(sb, pq, pq.poll());     // 대신 넣을 문자를 poll해서 StringBuilder에 삽입 처리
                pq.offer(p);                    // 중복되는 문자는 다시 우선순위큐로 삽입
            } else {
                process(sb, pq, p);
            }
        }
        
        return sb.toString();
    }
}

/*
Runtime: 1 ms, faster than 68.32% of Java online submissions for Longest Happy String.
Memory Usage: 36.1 MB, less than 90.36% of Java online submissions for Longest Happy String.
*/
