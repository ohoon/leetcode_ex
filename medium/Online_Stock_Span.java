/*
901.
Online Stock Span
https://leetcode.com/problems/online-stock-span/
*/

class StockSpanner {

    private Deque<int[]> stack;     // stack 사용
    
    public StockSpanner() {
        stack = new LinkedList<>();     // stack 구현체로 연결리스트 사용
    }
    
    public int next(int price) {
        int[] res = {price, 1};     // {대표 가격(상한가), 그룹 stock 개수}
        while (!stack.isEmpty()) {
            if (stack.peekLast()[0] > price) {      // price보다 큰 가격이 나오면 그룹 짓는 것을 멈춤
                break;
            }
            
            int[] popped = stack.removeLast();      // 현재 price보다 작은 stock들을 stack에서 삭제시키고 그룹 stock 개수를 늘려줌
            res[1] += popped[1];
        }
        
        stack.add(res);     // 해당 그룹 stock을 stack에 삽입
        return res[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/*
Runtime: 46 ms, faster than 55.83% of Java online submissions for Online Stock Span.
Memory Usage: 79.1 MB, less than 45.49% of Java online submissions for Online Stock Span.
*/
