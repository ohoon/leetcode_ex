/*
1387.
Sort Integers by The Power Value
https://leetcode.com/problems/sort-integers-by-the-power-value/
*/

class Solution {
    private Map<Integer, Integer> map;      // 메모라이징하기 위한 해시맵 선언
    
    private int getPower(int x) {
        if (map.containsKey(x)) {           // 한번 계산된 반환값이 존재하면 재사용
            return map.get(x);
        }
        
        int result = (x % 2 == 0) ? (1 + getPower(x/2)) : (1 + getPower(3*x + 1));      // 짝수, 홀수에 따라 다른 결과값 계산
        map.put(x, result);                 // 해시맵에 등록해서 나중에 재사용
        return result;
    }
    
    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            list.add(i);
        }
        
        map = new HashMap<>();          // 메모라이징 해시맵 정의
        map.put(1, 1);
        Collections.sort(list, (n1, n2) -> {
            int p1 = getPower(n1);
            int p2 = getPower(n2);
            return (p1 != p2) ? (p1 - p2) : (n1 - n2);
        });
        
        return list.get(k-1);
    }
}

/*
Runtime: 69 ms, faster than 48.74% of Java online submissions for Sort Integers by The Power Value.
Memory Usage: 38.6 MB, less than 77.97% of Java online submissions for Sort Integers by The Power Value.
*/
