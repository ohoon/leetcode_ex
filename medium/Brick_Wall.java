/*
554.
Brick Wall
https://leetcode.com/problems/brick-wall/
*/

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = wall.size(), maximum = 0;
        for (List<Integer> bricks : wall) {
            int cur = 0;        // 현재 x축 인덱스
            for (int i = 0; i < bricks.size() - 1; i++) {
                int brick = bricks.get(i);
                cur += brick;   // 블럭 모서리 위치로 이동
                
                int count = map.getOrDefault(cur, 0) + 1;       // 블럭 모서리 위치마다 카운팅하여 해시맵에 누적시킴
                map.put(cur, count);
                maximum = Math.max(maximum, count);             // y축으로 선을 그릴때 블럭 모서리가 가장 많은 부분을 지나야 cross되는 값이 최소가 됨
            }
        }
        
        return answer - maximum;
    }
}

/*
Runtime: 12 ms, faster than 25.64% of Java online submissions for Brick Wall.
Memory Usage: 53.7 MB, less than 5.93% of Java online submissions for Brick Wall.
*/
