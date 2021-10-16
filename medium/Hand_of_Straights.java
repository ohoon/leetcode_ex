/*
846.
Hand of Straights
https://leetcode.com/problems/hand-of-straights/
*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new TreeMap<>();        // key 값이 정렬된 상태여야 하기 때문에 treemap을 사용
        for (int h : hand) {                                // 카운팅
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        
        for (int k : map.keySet()) {
            while (map.get(k) > 0) {
                for (int i = 0; i < groupSize; i++) {       // 그룹 사이즈만큼 key를 연속적으로 탐색
                    if (!map.containsKey(k+i) || map.get(k+i) == 0) {
                        return false;
                    }

                    map.put(k+i, map.get(k+i) - 1);
                }
            }
        }
        
        return true;
    }
}

/*
Runtime: 67 ms, faster than 37.71% of Java online submissions for Hand of Straights.
Memory Usage: 41.1 MB, less than 44.34% of Java online submissions for Hand of Straights.
*/
