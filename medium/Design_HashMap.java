/*
706.
Design HashMap
https://leetcode.com/problems/design-hashmap/
*/

class MyHashMap {

    private int[] map;
    
    public MyHashMap() {
        map = new int[1000001];     // 입력값이 0 ~ 10^6이기 때문에 배열을 사용
        Arrays.fill(map, -1);       // map에 등록되지 않은 key의 value는 -1로 설정
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

/*
Runtime: 94 ms, faster than 20.52% of Java online submissions for Design HashMap.
Memory Usage: 110.2 MB, less than 16.17% of Java online submissions for Design HashMap.
*/
