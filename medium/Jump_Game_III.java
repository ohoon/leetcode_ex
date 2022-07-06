/*
1306.
Jump Game III
https://leetcode.com/problems/jump-game-iii/
*/

class Solution {
    public boolean canReach(int[] arr, int start) {
        Deque<Integer> deq = new LinkedList<>();        // queue로 이용
        boolean[] visited = new boolean[arr.length];    // 이미 방문한 곳 체크
        deq.addLast(start);
        while (!deq.isEmpty()) {
            int p = deq.removeFirst();
            if (visited[p]) {       // 이미 탐색해본 곳은 무시
                continue;
            }
            
            if (arr[p] == 0) {      // 0을 찾으면 종료
                return true;
            }
            
            if (p - arr[p] >= 0) {      // 왼쪽으로 점프
                deq.addLast(p - arr[p]);
            }
            
            if (p + arr[p] < arr.length) {      // 오른쪽으로 점프
                deq.addLast(p + arr[p]);
            }
            
            visited[p] = true;
        }
        
        return false;
    }
}

/*
Runtime: 17 ms, faster than 19.94% of Java online submissions for Jump Game III.
Memory Usage: 62.1 MB, less than 37.17% of Java online submissions for Jump Game III.
*/
