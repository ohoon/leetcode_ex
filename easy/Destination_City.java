/*
1436.
Destination City
https://leetcode.com/problems/destination-city/
*/

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {               // (출발지, 목적지) 해시맵 구축
            map.put(path.get(0), path.get(1));
        }
        
        String start = paths.get(0).get(0);
        while (map.containsKey(start)) {                // dfs로 루트가 끝날 때까지 반복 탐색
            start = map.get(start);
        }
        
        return start;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Destination City.
Memory Usage: 38.4 MB, less than 86.93% of Java online submissions for Destination City.
*/
