/*
2231.
Largest Number After Digit Swaps by Parity
https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
*/

class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>((x, y) -> y - x);     // 내림차순으로 정렬하는 우선순위 큐
        PriorityQueue<Integer> odd = new PriorityQueue<>((x, y) -> y - x);
        String numStr = String.valueOf(num);
        for (char c : numStr.toCharArray()) {       // 각 digit을 짝수, 홀수에 맞는 우선순위 큐에 삽입
            int digit = c - '0';
            if (digit % 2 == 0) {
                even.offer(digit);
            } else {
                odd.offer(digit);
            }
        }
        
        int answer = 0;
        for (char c : numStr.toCharArray()) {           // 각 digit이 짝수면 even 우선순위 큐에서, 홀수면 odd 우선순위 큐에서 poll하여 answer에 더해줌
            int digit = c - '0';
            if (digit % 2 == 0) {
                answer = answer * 10 + even.poll();
            } else {
                answer = answer * 10 + odd.poll();
            }
        }
        
        return answer;
    }
}

/*
Runtime: 5 ms, faster than 50.00% of Java online submissions for Largest Number After Digit Swaps by Parity.
Memory Usage: 40.9 MB, less than 100.00% of Java online submissions for Largest Number After Digit Swaps by Parity.
*/
