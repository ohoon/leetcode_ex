/*
1207.
Unique Number of Occurrences
https://leetcode.com/problems/unique-number-of-occurrences/
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();                 // 숫자 반복 횟수의 중복 체크용
        for (int num : arr) {                                   // 숫자 반복 횟수 측정
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        for (int key : map.keySet()) {                          // 숫자 반복 횟수를 set에 넣으면서 중복된 값이 있으면 false 반환
            if (!set.add(map.get(key))) {
                return false;
            }
        }
        
        return true;                                            // 정상적으로 완료되면 true 반환
    }
}

/*
Runtime: 1 ms, faster than 99.94% of Java online submissions for Unique Number of Occurrences.
Memory Usage: 37.1 MB, less than 42.94% of Java online submissions for Unique Number of Occurrences.
*/
