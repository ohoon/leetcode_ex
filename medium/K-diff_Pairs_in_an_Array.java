/*
532.
K-diff Pairs in an Array
https://leetcode.com/problems/k-diff-pairs-in-an-array/
*/

class Solution {
    public int findPairs(int[] nums, int k) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();        // 요소 개수를 카운팅하기 위한 hashmap
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);     // 카운팅
        }
        
        for (int num : map.keySet()) {
            if ((k == 0 && map.get(num) > 1) || (k > 0 && map.containsKey(num + k))) {      // k == 0일 때는 같은 요소가 2개 이상인가? k > 0일 때는 pair가 될 요소가 map에 있는지 검사
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 24 ms, faster than 21.20% of Java online submissions for K-diff Pairs in an Array.
Memory Usage: 48.4 MB, less than 7.92% of Java online submissions for K-diff Pairs in an Array.
*/
