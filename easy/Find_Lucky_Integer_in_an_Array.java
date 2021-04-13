/*
1394.
Find Lucky Integer in an Array
https://leetcode.com/problems/find-lucky-integer-in-an-array/
*/

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = -1;
        for (int elem : arr) {                          // arr 요소들 count
            if (map.containsKey(elem)) {
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }
        }
        
        for (Integer key : map.keySet()) {
            if (key == map.get(key) && key > answer) {  // key와 그 개수가 같고 answer보다 큰 값이면 answer 갱신
                answer = key;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 55.68% of Java online submissions for Find Lucky Integer in an Array.
Memory Usage: 38.7 MB, less than 28.53% of Java online submissions for Find Lucky Integer in an Array.
*/
