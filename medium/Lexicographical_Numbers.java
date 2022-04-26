/*
386.
Lexicographical Numbers
https://leetcode.com/problems/lexicographical-numbers/
*/

class Solution {
    private void dfs(List<Integer> list, int n, int curr) {        // 깊이 우선 탐색
        for (int i = 0; i <= 9; i++) {
            int next = curr * 10 + i;
            if (next == 0 || next > n) {        // next가 0이 되면 무한 순회가 일어나고, n을 초과하면 조건에 성립하지 않음
                continue;
            }
            
            list.add(next);
            dfs(list, n, next);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        dfs(answer, n, 0);
        return answer;
    }
}

/*
Runtime: 6 ms, faster than 61.21% of Java online submissions for Lexicographical Numbers.
Memory Usage: 57 MB, less than 31.74% of Java online submissions for Lexicographical Numbers.
*/
