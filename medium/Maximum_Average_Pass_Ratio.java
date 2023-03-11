/*
1792.
Maximum Average Pass Ratio
https://leetcode.com/problems/maximum-average-pass-ratio/
*/

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {     // 
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Double.compare((double) (y[0] + 1) / (y[1] + 1) - (double) y[0] / y[1], (double) (x[0] + 1) / (x[1] + 1) - (double) x[0] / x[1]));
        for (int[] c : classes) {
            pq.offer(c);
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] p = pq.poll();
            pq.offer(new int[]{p[0] + 1, p[1] + 1});
        }

        double answer = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            answer += (double) poll[0] / poll[1];
        }

        answer /= classes.length;
        return answer;
    }
}
