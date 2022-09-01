/*
2336.
Smallest Number in Infinite Set
https://leetcode.com/problems/smallest-number-in-infinite-set/
*/

class SmallestInfiniteSet {
    private PriorityQueue<Integer> pq;
    
    private int cur;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        cur = 1;
    }
    
    public int popSmallest() {
        if (!pq.isEmpty()) {
            int num = pq.peek();
            while (!pq.isEmpty() && pq.peek() == num) {     // 중복되는 숫자를 모두 빼내는 작업
                pq.poll();
            }
            
            return num;
        }
        
        return cur++;
    }
    
    public void addBack(int num) {
        if (num >= cur) {
            return;
        }
        
        pq.offer(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

/*
Runtime: 22 ms, faster than 70.86% of Java online submissions for Smallest Number in Infinite Set.
Memory Usage: 54.2 MB, less than 77.09% of Java online submissions for Smallest Number in Infinite Set.
*/
