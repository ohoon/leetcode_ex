/*
1296.
Divide Array in Sets of K Consecutive Numbers
https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
*/

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();    // 숫자를 오름차순으로 꺼내서 탐색할 것이기 때문에 treemap을 사용했음
        for (int num : nums) {                          // 각 숫자별로 개수 카운팅
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : map.keySet()) {
            int cnt = map.get(num);
            if (cnt == 0) {
                continue;
            }
            
            map.put(num, 0);
            for (int i = 1; i < k; i++) {                   // 이 다음 k-1개의 요소들의 개수를 cnt만큼 빼줌
                int c = map.getOrDefault(num + i, 0);
                if (c - cnt < 0) {      // k개로 묶기에 해당 요소 개수가 부족하면 false 반환
                    return false;
                }
                
                map.put(num + i, c - cnt);
            }
        }
        
        return true;
    }
}

/*
Runtime: 201 ms, faster than 44.33% of Java online submissions for Divide Array in Sets of K Consecutive Numbers.
Memory Usage: 80.3 MB, less than 37.82% of Java online submissions for Divide Array in Sets of K Consecutive Numbers.
*/
