/*
981.
Time Based Key-Value Store
https://leetcode.com/problems/time-based-key-value-store/
*/

class TimeMap {

    private TreeMap<Integer, Map<String, String>> timeMap;      // floorKey()를 쓰기 위해서 TreeMap 사용
    
    /** Initialize your data structure here. */
    public TimeMap() {
        this.timeMap = new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(timestamp)) {
            timeMap.put(timestamp, new HashMap<>());
        }

        timeMap.get(timestamp).put(key, value);
    }
    
    public String get(String key, int timestamp) {
        Integer ts = timeMap.floorKey(timestamp);       // 주어진 timestamp에 가장 가깝고 작은 time key를 가져옴
        while (ts != null) {
            if (!timeMap.get(ts).containsKey(key)) {
                ts = timeMap.floorKey(ts-1);        // 해당 time의 hashMap에 key가 없으면 다음 time
                continue;
            }

            return timeMap.get(ts).get(key);
        }

        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
