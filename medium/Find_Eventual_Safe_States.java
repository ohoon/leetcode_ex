/*
802.
Find Eventual Safe States
https://leetcode.com/problems/find-eventual-safe-states/
*/

class Solution {
    private boolean isLooped(int[][] graph, int curr, boolean[] visited, Boolean[] cache) {
        if (cache[curr] != null) {      // 이전에 탐색한 노드면 결과를 바로 반환
            return cache[curr];
        }

        if (visited[curr]) {        // 사이클이 발생하는 경우
            cache[curr] = true;
            return true;
        }

        boolean res = false;
        visited[curr] = true;
        for (int next : graph[curr]) {
            if (isLooped(graph, next, visited, cache)) {        // 이어진 노드로 순회
                res = true;
                break;
            }
        }

        visited[curr] = false;
        cache[curr] = res;
        return res;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> answer = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            if (isLooped(graph, i, new boolean[n], new Boolean[n])) {
                continue;
            }

            answer.add(i);
        }

        return answer;
    }
}
