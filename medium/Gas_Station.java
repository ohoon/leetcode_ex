/*
134.
Gas Station
https://leetcode.com/problems/gas-station/
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0, start = 0;
        boolean[] tries = new boolean[n];       // 인덱스별 탐색 시도 여부
        while (start < n) {
            if (tries[start]) {                 // 이미 시도한 인덱스에서 재차 탐색이 일어날 경우 해답이 없으므로 -1 반환하고 종료
                return -1;
            }
            
            int cur = start;
            total = gas[cur] - cost[cur];
            tries[start] = true;
            while (total >= 0) {                // 값을 누적시켜 0이상이 될 때까지 반복
                cur = (cur + 1) % n;
                if (cur == start) {             // 모든 요소들을 방문하고 원래 인덱스로 돌아온다면 현재 인덱스를 반환하고 종료
                    return cur;
                }
                
                total += gas[cur] - cost[cur];
            }
            
            start = (cur + 1) % n;              // 탐색에 실패하면 실패한 인덱스 다음부터 새로 탐색 시작
        }
        
        return -1;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Gas Station.
Memory Usage: 39.3 MB, less than 54.97% of Java online submissions for Gas Station.
*/

/*
다른 사람의 풀이

public int canCompleteCircuit(int[] gas, int[] cost) {
    int tank = 0;
    for(int i = 0; i < gas.length; i++)
        tank += gas[i] - cost[i];
    if(tank < 0)
        return - 1;
        
    int start = 0;
    int accumulate = 0;
    for(int i = 0; i < gas.length; i++){
        int curGain = gas[i] - cost[i];
        if(accumulate + curGain < 0){
            start = i + 1;
            accumulate = 0;
        }
        else accumulate += curGain;
    }
    
    return start;
}

내 풀이방식과 같은 방법이지만 먼저 전체적으로 loop를 돌려 정답이 존재하는지 확인하고,
그 다음 loop에서 curGain값을 누적시켜 0이상이 나오는 지점을 찾아 반환하는 방식이다.
첫 번째 루프에서 정답이 있음을 보장하였기 때문에 배열을 순환할 필요없이 정답임을 확신할 수 있게 된다.
그렇기 때문에 tries와 같은 불린배열도 필요가 없어지고 % 연산도 생략할 수 있어 좋은 풀이라고 생각한다.

*/
