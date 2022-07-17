/*
2341.
Maximum Number of Pairs in Array
https://leetcode.com/problems/maximum-number-of-pairs-in-array/
*/

class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {        // counting
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int[] answer = new int[2];
        for (int n : map.keySet()) {
            answer[0] += map.get(n) / 2;        // 몫만큼 중복 숫자 제거
            answer[1] += map.get(n) % 2;        // 제거하고 남은 
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 20.00% of Java online submissions for Maximum Number of Pairs in Array.
Memory Usage: 42.7 MB, less than 60.00% of Java online submissions for Maximum Number of Pairs in Array.
*/
