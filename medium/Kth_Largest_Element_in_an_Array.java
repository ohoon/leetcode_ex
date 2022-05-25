/*
215.
Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();      // 오름차순으로 정렬되는 우선순위 큐
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {        // nums에서 k번째로 큰 수까지만 우선순위 큐에 저장됨
                pq.poll();
            }
        }
        
        return pq.poll();   // k번째로 큰 수 추출해서 반환
    }
}

/*
Runtime: 5 ms, faster than 64.40% of Java online submissions for Kth Largest Element in an Array.
Memory Usage: 45.3 MB, less than 20.62% of Java online submissions for Kth Largest Element in an Array.
*/
