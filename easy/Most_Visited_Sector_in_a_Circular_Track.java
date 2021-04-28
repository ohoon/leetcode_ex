/*
1560.
Most Visited Sector in a Circular Track
https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
*/

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> answer = new ArrayList<>();
        int[] visit = new int[n];           // 구역 방문 횟수
        int max = 0;                        // 최대 방문 횟수
        int cur = 0;                        // 현재 rounds 커서
        visit[rounds[0]-1]++;               // 출발점 방문횟수를 1 증가
        while (cur < rounds.length) {
            for (int i = 1; i <= n; i++) {
                if (cur >= rounds.length) { // rounds가 끝나면 break
                    break;
                }
                
                if (cur > 0) {              // 출발점 전에는 카운트하지 않음
                    visit[i-1]++;
                }
                
                if (i == rounds[cur]) {     // 라운드의 끝에 도달하면 최대 방문횟수와 커서 갱신
                    if (visit[i-1] > max) {
                        max = visit[i-1];
                    }
                    cur++;
                }
            }
        }
        
        for (int i = 0; i < visit.length; i++) {    // 최대 방문횟수에 해당하는 구역 번호만 answer에 추가
            if (visit[i] == max) {
                answer.add(i + 1);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 45.79% of Java online submissions for Most Visited Sector in a Circular Track.
Memory Usage: 39.4 MB, less than 10.75% of Java online submissions for Most Visited Sector in a Circular Track.
*/

/*
다른 사람의 풀이

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        var start = rounds[0];
        var end = rounds[rounds.length - 1];   
        var res = new ArrayList<Integer>();
        if (start <= end) {
            for (int i = start; i <= end; i++) res.add(i);
        } else {
            for (int i = 1; i <= end; i++) res.add(i);
            for (int i = start; i <= n; i++) res.add(i);
        }
        return res;
    }
}

나는 문제에서 주어진 과정에 따라 구현하느라 코드가 복잡해졌지만
사실상 출발점과 도착점을 가지고 원의 테두리를 여러번 지나간 구역을 세면 되는 간단한 것이었다..
구현에 집중하지 않고 조금 더 효율적으로 코드를 짤 생각을 해볼 걸 그랬다.

*/
