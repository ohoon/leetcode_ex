/*
1823.
Find the Winner of the Circular Game
https://leetcode.com/problems/find-the-winner-of-the-circular-game/
*/

class Solution {
    public int findTheWinner(int n, int k) {
        return dfs(n, k) + 1;
    }
    
    public int dfs(int n, int k) {
        if (n == 1) {
            return 0;
        }
        
        return (dfs(n-1, k) + k) % n;
    }
}

/*
Runtime: 1 ms, faster than 78.58% of Java online submissions for Find the Winner of the Circular Game.
Memory Usage: 41.5 MB, less than 40.49% of Java online submissions for Find the Winner of the Circular Game.
*/

/*
여담

이 문제는 Josephus Problem의 풀이와 같은 방식으로 풀면 된다.
재귀법으로 점점 n을 줄여가면서 마지막에 남은 값을 찾는다.
*/
