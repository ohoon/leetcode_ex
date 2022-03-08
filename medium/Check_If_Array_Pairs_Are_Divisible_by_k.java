/*
1479.
Check If Array Pairs Are Divisible by k
https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
*/

class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {         // k로 나눈 나머지를 key로 하여 카운팅
            int key = n % k;
            if (key < 0) {
                key += k;
            }
            
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            if ((key == 0 && map.get(key) % 2 > 0) ||       // 나머지가 0인 요소가 짝수개여야 pair가 성립
                (key > 0 && (!map.containsKey(k - key) ||           // 나머지가 1인 요소는 나머지가 k-1인 요소와 짝을 이루어야 하므로 k-key 요소의 개수와 같은지 비교
                             Integer.compare(map.get(key), map.get(k - key)) != 0))) {
                return false;
            }
        }
        
        return true;
    }
}

/*
Runtime: 60 ms, faster than 45.80% of Java online submissions for Check If Array Pairs Are Divisible by k.
Memory Usage: 98.8 MB, less than 27.10% of Java online submissions for Check If Array Pairs Are Divisible by k.
*/
