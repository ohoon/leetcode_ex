/*
826.
Most Profit Assigning Work
https://leetcode.com/problems/most-profit-assigning-work/
*/

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();        // key값이 자동으로 정렬되고, floorKey 메서드를 쓰기 위해 treemap을 사용
        map.put(0, 0);      // floorKey() 결과가 null값 나오는 것 방지
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));        // 같은 난이도의 작업은 profit이 높은 것을 선택
        }
        
        int prev = 0;
        for (int d : map.keySet()) {
            if (map.get(d) < prev) {        // 난이도가 더 높은데도 불구하고 profit이 더 낮은 경우에는 profit이 높은 저난이도 작업을 선택함
                map.put(d, prev);
            }
            
            prev = map.get(d);
        }
        
        int answer = 0;
        for (int w : worker) {
            answer += map.get(map.floorKey(w));     // 노동자의 능력에 맞는 작업을 floorkey로 내림하여 찾음
        }
        
        return answer;
    }
}

/*
Runtime: 135 ms, faster than 17.07% of Java online submissions for Most Profit Assigning Work.
Memory Usage: 69.9 MB, less than 11.04% of Java online submissions for Most Profit Assigning Work.
*/
