/*
2164.
Sort Even and Odd Indices Independently
https://leetcode.com/problems/sort-even-and-odd-indices-independently/
*/

class Solution {
    public int[] sortEvenOdd(int[] nums) {      // 우선순위 큐 사용 (heap sort)
        PriorityQueue<Integer> evenPq = new PriorityQueue<>();      // 짝수번째 요소는 오름차순
        PriorityQueue<Integer> oddPq = new PriorityQueue<>((x, y) -> y - x);        // 홀수번째 요소는 내림차순
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenPq.offer(nums[i]);
            } else {
                oddPq.offer(nums[i]);
            }
        }
        
        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = i % 2 == 0 ? evenPq.poll() : oddPq.poll();
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 75.00% of Java online submissions for Sort Even and Odd Indices Independently.
Memory Usage: 44.3 MB, less than 25.00% of Java online submissions for Sort Even and Odd Indices Independently.
*/
