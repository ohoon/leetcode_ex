/*
436.
Find Right Interval
https://leetcode.com/problems/find-right-interval/
*/

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] answer = new int[intervals.length];
        Map<Integer, Integer> indexMap = new TreeMap<>();
        Map<Integer, Integer> resultMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            indexMap.put(intervals[i][0], i);
            resultMap.put(intervals[i][1], -1);
        }

        Deque<Integer> deq = new LinkedList<>(indexMap.keySet());
        for (int end : resultMap.keySet()) {
            while (!deq.isEmpty()) {
                int front = deq.getFirst();
                if (front >= end) {
                    resultMap.put(end, indexMap.get(front));
                    break;
                } else {
                    deq.removeFirst();
                }
            }
        }

        for (int i = 0; i < intervals.length; i++) {
            answer[i] = resultMap.get(intervals[i][1]);
        }

        return answer;
    }
}

/*
Runtime: 49 ms, faster than 25.04% of Java online submissions for Find Right Interval.
Memory Usage: 58 MB, less than 5.68% of Java online submissions for Find Right Interval.
*/
