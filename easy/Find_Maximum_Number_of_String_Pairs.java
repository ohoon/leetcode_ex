/*
2744.
Find Maximum Number of String Pairs
https://leetcode.com/problems/find-maximum-number-of-string-pairs/
*/

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            String rw = new StringBuilder(w).reverse().toString();
            if (map.getOrDefault(rw, 0) > 0) {
                map.put(rw, map.get(rw) - 1);
                answer++;
            } else {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }

        return answer;
    }
}
