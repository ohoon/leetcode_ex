/*
1971.
Find if Path Exists in Graph
https://leetcode.com/problems/find-if-path-exists-in-graph/
*/

class Solution {
    int[] origins;      // union의 근원지(대표) 정점을 기록하는 배열
    
    private int findOrigin(int u) {     // 해당 정점은 어떤 union을 가지는지 (어떤 대표 정점을 가리키고 있는지)
       return origins[u] == u ? u : (origins[u] = findOrigin(origins[u]));      // 자기 자신이 근원지라면 origins[u]의 값은 u로 자기 자신과 같음. 다르면 순환적으로 origin 탐색
    }
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        origins = new int[n];
        for (int i = 0; i < n; i++) {
            origins[i] = i;
        }
        
        for(int[] e : edges) {
            int o1 = findOrigin(e[0]);
            int o2 = findOrigin(e[1]);
            if (o1 != o2) {
                origins[o1] = o2;
            }
        }
        
        return findOrigin(start) == findOrigin(end);        // 시작 정점과 끝 정점이 같은 origin을 가지지 않으면, false 반환
    }
}

/*
Runtime: 10 ms, faster than 94.57% of Java online submissions for Find if Path Exists in Graph.
Memory Usage: 94.7 MB, less than 90.17% of Java online submissions for Find if Path Exists in Graph.
*/

/*
여담

union find를 이용해서 풀어야 겠다고 생각이 들었지만 많이 사용해본 적이 없는 알고리즘이라 구현하는데 어려움을 겪었다.
원래 내 코드와 작동 흐름은 비슷한 것 같은데 왜 안됐었는지 의문이다..

*/
