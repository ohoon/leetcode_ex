/*
1525.
Number of Good Ways to Split a String
https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
*/

class Solution {
    public int numSplits(String s) {
        int answer = 0;
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        for (char c : s.toCharArray()) {                        // right map을 전체 s를 기준으로 초기화
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {                  // s의 앞에서부터 차례대로 탐색하면서 left에는 추가하고 right에는 감소시키는 식으로 전개
            char key = s.charAt(i);
            left.put(key, left.getOrDefault(s.charAt(i), 0) + 1);
            if (right.get(key) == 1) {
                right.remove(key);
            } else {
                right.put(key, right.get(key) - 1);
            }
            
            if (left.keySet().size() == right.keySet().size()) {        // left와 right의 key 개수가 동일하면 answer 증가
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 58 ms, faster than 13.25% of Java online submissions for Number of Good Ways to Split a String.
Memory Usage: 52.3 MB, less than 5.66% of Java online submissions for Number of Good Ways to Split a String.
*/
