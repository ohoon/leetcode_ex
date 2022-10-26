/*
503.
Next Greater Element II
https://leetcode.com/problems/next-greater-element-ii/
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);       // 오름차순 정렬 우선순위 큐
        for (int i = 0; i < n; i++) {       // -1으로 초기화
            answer[i] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < nums[i]) {
                answer[pq.poll()[0]] = nums[i];
            }
            
            pq.offer(new int[]{i, nums[i]});
        }
        
        while (!pq.isEmpty()) {     // circularly하게 next greater element 탐색
            int[] p = pq.poll();
            for (int i = 0; i < p[0]; i++) {
                if (nums[i] > p[1]) {
                    answer[p[0]] = nums[i];
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 25 ms, faster than 86.65% of Java online submissions for Next Greater Element II.
Memory Usage: 55.4 MB, less than 18.09% of Java online submissions for Next Greater Element II.
*/
