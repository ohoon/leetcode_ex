/*
1414.
Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
*/

class Solution {
    public int findMinFibonacciNumbers(int k) {     // greedy
        if (k == 1) {
            return 1;
        }
        
        Deque<Integer> deq = new LinkedList<>();        // stack 용도로 사용
        int prev = 1;       // deq.peekLast() 이전의 값
        deq.addLast(1);
        deq.addLast(1);
        while (deq.peekLast() < k) {
            int next = prev + deq.peekLast();
            prev = deq.peekLast();      // prev 값 갱신
            deq.addLast(next);
        }
        
        int answer = 0;
        while (!deq.isEmpty() && k > 0) {
            int p = deq.removeLast();
            if (p > k) {
                continue;
            }
            
            k -= p;
            answer++;
        }
        
        return k == 0 ? answer : -1;
    }
}

/*
Runtime: 3 ms, faster than 67.41% of Java online submissions for Find the Minimum Number of Fibonacci Numbers Whose Sum Is K.
Memory Usage: 42.4 MB, less than 22.77% of Java online submissions for Find the Minimum Number of Fibonacci Numbers Whose Sum Is K.
*/
