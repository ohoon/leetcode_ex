/*
2206.
Divide Array Into Equal Pairs
https://leetcode.com/problems/divide-array-into-equal-pairs/
*/

class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {              // nums의 요소들의 개수를 카운팅
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : map.keySet()) {      // 각 요소들의 개수가 2로 나누어 떨어지지 않으면 equal pair로 divide할 수 없기 때문에 false 반환
            if (map.get(num) % 2 > 0) {
                return false;
            }
        }
        
        return true;
    }
}

/*
Runtime: 5 ms, faster than 85.71% of Java online submissions for Divide Array Into Equal Pairs.
Memory Usage: 42.1 MB, less than 85.71% of Java online submissions for Divide Array Into Equal Pairs.
*/
