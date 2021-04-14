/*
1403.
Minimum Subsequence in Non-Increasing Order
https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
*/

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());      // heap을 사용하기 위한 priority queue
        List<Integer> answer = new ArrayList<Integer>();
        int total = 0;
        int current = 0;
        for (int num : nums) {          // heap에 값을 넣고 total 갱신
            heap.offer(num);
            total += num;
        }
        
        int target = total / 2;
        while (current <= target) {     // 합이 target을 넘을때까지 heap에서 값을 빼서 작업하는 것을 반복
            int num = heap.poll();
            answer.add(num);
            current += num;
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 18.97% of Java online submissions for Minimum Subsequence in Non-Increasing Order.
Memory Usage: 38.9 MB, less than 86.55% of Java online submissions for Minimum Subsequence in Non-Increasing Order.
*/
