/*
797.
All Paths From Source to Target
https://leetcode.com/problems/all-paths-from-source-to-target/
*/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(graph, 0, new ArrayList<Integer>(), answer);
        return answer;
    }
    
    private void dfs(int[][] graph, int node, List<Integer> list, List<List<Integer>> answer) {
        list.add(node);         // 현재 노드 번호를 list에 추가
        if (node < graph.length - 1) {      // 그 다음 노드로 깊이 우선 탐색
            for (int nextNode : graph[node]) {
                dfs(graph, nextNode, list, answer);
            }
        } else {                            // 마지막 노드인 경우 answer에 list를 추가
            answer.add(new ArrayList<>(list));
        }
        
        list.remove(list.size() - 1);       // 현재 노드에 대한 탐색이 모두 끝나면 list에서 제거
    }
}

/*
Runtime: 2 ms, faster than 94.80% of Java online submissions for All Paths From Source to Target.
Memory Usage: 40.8 MB, less than 54.43% of Java online submissions for All Paths From Source to Target.
*/
