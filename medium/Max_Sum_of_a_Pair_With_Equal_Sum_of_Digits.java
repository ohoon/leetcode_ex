/*
2342.
Max Sum of a Pair With Equal Sum of Digits
https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
*/

class Solution {
    public int maximumSum(int[] nums) {         // 우선순위 큐
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int digitSum = 0, m = num;
            while (m > 0) {
                digitSum += m % 10;
                m /= 10;
            }

            if (!map.containsKey(digitSum)) {
                map.put(digitSum, new PriorityQueue<>((x, y) -> y.compareTo(x)));
            }

            map.get(digitSum).offer(num);
        }

        int answer = -1;
        for (int digitSum : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(digitSum);
            if (pq.size() <= 1) {
                continue;
            }

            answer = Math.max(answer, pq.poll() + pq.poll());
        }

        return answer;
    }
}
