/*
150.
Evaluate Reverse Polish Notation
https://leetcode.com/problems/evaluate-reverse-polish-notation/
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deq = new LinkedList<>();        // 스택용 dequeue
        int first, second;
        for (String tk : tokens) {
            try {
                deq.addLast(Integer.parseInt(tk));      // 토큰을 숫자로 변환, 변환에 실패하면 연산자이므로 catch에서 처리
            } catch (NumberFormatException e) {
                second = deq.removeLast();
                first = deq.removeLast();
                if (tk.equals("+")) {
                    deq.addLast(first + second);
                } else if (tk.equals("-")) {
                    deq.addLast(first - second);
                } else if (tk.equals("*")) {
                    deq.addLast(first * second);
                } else {
                    deq.addLast(first / second);
                }
            }
        }
        
        return deq.removeLast();
    }
}

/*
Runtime: 18 ms, faster than 7.88% of Java online submissions for Evaluate Reverse Polish Notation.
Memory Usage: 40.2 MB, less than 16.21% of Java online submissions for Evaluate Reverse Polish Notation.
*/

/*
여담

처음에는 토큰들 자체를 stack에다가 담고 하나씩 pop하여 순회식으로 풀이하였는데,
다른 사람 풀이를 보고 생각을 해보니 아예 처음 토큰부터 스택에 넣으면서 연산자를 만나면 스택에 있는 값을 pop하여 처리하는 것이 훨씬 효율적이라고 생각이 들어서
새로 코드를 짜서 풀이했다.
100% 내 생각으로 풀이한 것이 아니라 나중에 다시 풀어야 할 듯 싶다.

*/
