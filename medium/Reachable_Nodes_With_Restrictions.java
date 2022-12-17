/*
2368.
Reachable Nodes With Restrictions
https://leetcode.com/problems/reachable-nodes-with-restrictions/
*/

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, Set<Integer>> map = new HashMap<>();       // 연결관계를 hashmap으로 표현
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new HashSet<>());
            }

            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new HashSet<>());
            }

            map.get(edge[0]).add(edge[1]);      // 양방향 연결 관계
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> restrictedSet = new HashSet<>();       // 제약된 노드 번호를 기록하는 hashset
        for (int r : restricted) {
            restrictedSet.add(r);
        }

        int answer = 0;
        Deque<Integer> deq = new LinkedList<>();        // deque를 이용한 DFS
        deq.addFirst(0);
        while (!deq.isEmpty()) {
            int curr = deq.removeFirst();
            if (restrictedSet.contains(curr)) {
                continue;
            }

            answer++;
            for (int next : map.getOrDefault(curr, new HashSet<>())) {
                deq.addFirst(next);
                map.get(next).remove(curr);     // 사이클을 막기 위함
            }
        }

        return answer;
    }
}
