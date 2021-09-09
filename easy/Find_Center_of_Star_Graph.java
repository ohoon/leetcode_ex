/*
1791.
Find Center of Star Graph
https://leetcode.com/problems/find-center-of-star-graph/
*/

class Solution {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];        // 첫번째와 두번째 원소만 비교하면 끝
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Center of Star Graph.
Memory Usage: 64.5 MB, less than 73.65% of Java online submissions for Find Center of Star Graph.
*/
