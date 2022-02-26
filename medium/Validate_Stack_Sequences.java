/*
946.
Validate Stack Sequences
https://leetcode.com/problems/validate-stack-sequences/
*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deq = new LinkedList<>();    // stack용 deque
        int cur = 0;        // popped index
        for (int num : pushed) {
            deq.add(num);       // push
            while (!deq.isEmpty() && deq.peekLast() == popped[cur]) {       // 현재 stack의 peek가 popped에서 가리키는 요소라면 pop시킴
                deq.removeLast();
                cur++;
            }
        }
        
        return deq.isEmpty();       // 모두 정상적으로 pop되면 true
    }
}

/*
Runtime: 3 ms, faster than 75.54% of Java online submissions for Validate Stack Sequences.
Memory Usage: 45.2 MB, less than 22.53% of Java online submissions for Validate Stack Sequences.
*/
