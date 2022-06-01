/*
2208.
Minimum Operations to Halve Array Sum
https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
*/

class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));       // 동적으로 가장 큰 수를 뽑아내기 위해서 우선순위 큐 사용
        for (int num : nums) {
            pq.offer((double) num);
        }
        
        int answer = 0;
        double sum = pq.stream().mapToDouble(i->i).sum();
        double target = sum / 2;        // 처음 sum의 절반으로 합을 줄이는 것이 목표
        while (sum > target) {
            double n = pq.poll();
            sum -= n / 2;           // 줄여진 만큼 sum에서 감소
            pq.offer(n / 2);        // 줄여진 값을 우선순위 큐에 재차 삽입
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 443 ms, faster than 15.62% of Java online submissions for Minimum Operations to Halve Array Sum.
Memory Usage: 106.7 MB, less than 59.44% of Java online submissions for Minimum Operations to Halve Array Sum.
*/
