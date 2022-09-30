/*
1396.
Design Underground System
https://leetcode.com/problems/design-underground-system/
*/

class UndergroundSystem {
    
    private Map<Integer, Pair<String, Integer>> checkMap;       // 체크인, 체크아웃 관리
    
    private Map<String, int[]> timeMap;     // 이동시간 관리

    public UndergroundSystem() {
        checkMap = new HashMap<>();
        timeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkMap.put(id, new Pair<>(stationName, t));       // 체크인
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> p = checkMap.get(id);
        String path = p.getKey() + ">" + stationName;       // 출발지>도착지로 key 관리
        int time = t - p.getValue();
        if (!timeMap.containsKey(path)) {
            timeMap.put(path, new int[2]);      // {사람수, 총 이동시간}
        }
        
        int[] tv = timeMap.get(path);
        tv[0]++;
        tv[1] += time;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] tv = timeMap.get(startStation + ">" + endStation);
        return (double) tv[1] / tv[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

/*
Runtime: 279 ms, faster than 7.80% of Java online submissions for Design Underground System.
Memory Usage: 99 MB, less than 79.77% of Java online submissions for Design Underground System.
*/
