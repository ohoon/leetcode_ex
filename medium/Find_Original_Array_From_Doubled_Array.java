/*
2007.
Find Original Array From Doubled Array
https://leetcode.com/problems/find-original-array-from-doubled-array/
*/

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {           // 홀수 개면 doubled array가 될 수 없음
            return new int[0];
        }
        
        int[] answer = new int[n/2];
        Map<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        Arrays.sort(changed);       // 오름차순 정렬
        for (int c : changed) {
            if (c % 2 == 1 || !map.containsKey(c/2)) {      // 값이 홀수거나 map에 original 값이 없으면 현재 숫자가 original로 가정함
                map.put(c, map.getOrDefault(c, 0) + 1);
                continue;
            }
            
            map.put(c/2, map.get(c/2) - 1);         // map에 original 값이 있으면 개수를 감소시키고 해당 original을 answer에 추가
            answer[cur++] = c/2;
            if (map.get(c/2) == 0) {                // 개수가 0이 되면 map에서 삭제
                map.remove(c/2);
            }
        }
        
        return map.size() == 0 ? answer : new int[0];       // 아직 짝을 찾지 못한 original이 남아있으면 빈 배열 
    }
}

/*
Runtime: 220 ms, faster than 47.01% of Java online submissions for Find Original Array From Doubled Array.
Memory Usage: 129.3 MB, less than 68.55% of Java online submissions for Find Original Array From Doubled Array.
*/
