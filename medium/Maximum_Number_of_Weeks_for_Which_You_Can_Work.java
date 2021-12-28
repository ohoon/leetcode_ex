/*
1953.
Maximum Number of Weeks for Which You Can Work
https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
*/

class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = IntStream.of(milestones).asLongStream().sum();
        long max = IntStream.of(milestones).max().getAsInt();
        return Math.min(sum, 2 * (sum - max) + 1);      // 가장 큰 수인 max와 나머지 수 들의 합인 (sum - max)를 비교함.
                                                        // max가 sum의 절반 이하라면 모든 수들이 work될 수 있고, 절반보다 크다면 (sum - max) * 2 + 1만큼 work될 수 있다.
    }
}

/*
Runtime: 13 ms, faster than 12.10% of Java online submissions for Maximum Number of Weeks for Which You Can Work.
Memory Usage: 48.5 MB, less than 57.26% of Java online submissions for Maximum Number of Weeks for Which You Can Work.
*/

/*
나의 풀이

class Solution {
    public long numberOfWeeks(int[] milestones) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> milestones[j] - milestones[i]);
        for (int i = 0; i < milestones.length; i++) {
            pq.offer(i);
        }
        
        while (!pq.isEmpty()) {
            int i = pq.poll();
            if (pq.isEmpty()) {
                return answer + 1;
            }
            
            int j = pq.poll();
            if (--milestones[i] > 0) {
                pq.offer(i);
            }
            
            if (--milestones[j] > 0) {
                pq.offer(j);
            }
            
            answer += 2;
        }
        
        return answer;
    }
}

내가 풀이할 때는 우선순위 큐를 사용해서 푸는게 맞다고 생각이 들어서 그렇게 구현을 했다.
하지만 시간 초과 오류가 나면서 난관에 부딪혔음
어떻게 하면 최적화를 할 수 있을까 생각을 해봤지만 시간 제한이 너무 빡빡해서 어떻게 뭘 할 수가 없었다.
다른 사람이 쓴 코드를 쭉 읽어보니 아예 큐 자체를 안 써도 충분히 풀 수 있음을 알았다.
가장 큰 수와 나머지 수들의 합으로 나눠서 생각을 해보니 굳이 하나씩 삽입하고 감소시키고 할 필요 없이
가장 큰 수를 모두 소화시킬 수 있나 아닌가에 초점을 맞춰 풀면 간단하게 풀 수 있는 문제였다.
풀이해가는 방식이 되게 독특하고 재밌어서 꼭 다시 내 힘으로 풀어보고 싶은 문제였음
*/
