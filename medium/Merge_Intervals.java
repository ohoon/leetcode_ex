/*
56.
Merge Intervals
https://leetcode.com/problems/merge-intervals/
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        Deque<int[]> deq = new LinkedList<>();              // stack용 deque
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);      // start 시간을 기준으로 정렬
        for (int[] interval : intervals) {
            if (deq.isEmpty() || deq.getLast()[1] < interval[0]) {      // 겹치는 부분이 없으면 그대로 삽입
                deq.addLast(interval);
            } else {                                        // 겹치는 부분이 있으면 deq에서 꺼내와서 end 시간 수정해서 재삽입
                int[] pop = deq.removeLast();
                pop[1] = Math.max(pop[1], interval[1]);
                deq.addLast(pop);
            }
        }

        return deq.toArray(new int[deq.size()][2]);
    }
}

/*
Runtime: 6 ms, faster than 59.81% of Java online submissions for Merge Intervals.
Memory Usage: 41.6 MB, less than 63.91% of Java online submissions for Merge Intervals.
*/

/*
여담

처음엔 bucket을 이용해서 풀이하려다가
bucket을 사용하면 [0, 0]처럼 start 시간과 end 시간이 같은 경우를 처리하기 어렵다는 점을 발견해서
sorting해서 stack에 넣고 빼고하는 식의 풀이로 바꿨다.

 */