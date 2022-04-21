/*
945.
Minimum Increment to Make Array Unique
https://leetcode.com/problems/minimum-increment-to-make-array-unique/
*/

class Solution {
    public int minIncrementForUnique(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();      // 오름차순으로 정렬되는 우선순위 큐
        for (int num : nums) {      // 모든 원소 삽입
            pq.offer(num);
        }
        
        int answer = 0, prev = -1;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (curr <= prev) {         // 현재 값이 이전 값 이하라면 현재 값을 이전 값+1이 되도록 move함
                answer += prev - curr + 1;
                prev++;
                continue;
            }
            
            prev = curr;                // 현재 값이 이전 값 초과하면 정상적으로 이전 값만 갱신시켜줌
        }
        
        return answer;
    }
}

/*
Runtime: 194 ms, faster than 14.53% of Java online submissions for Minimum Increment to Make Array Unique.
Memory Usage: 56.5 MB, less than 70.95% of Java online submissions for Minimum Increment to Make Array Unique.
*/
