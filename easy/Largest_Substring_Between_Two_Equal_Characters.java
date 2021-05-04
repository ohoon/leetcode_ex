/*
1624.
Largest Substring Between Two Equal Characters
https://leetcode.com/problems/largest-substring-between-two-equal-characters/
*/

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {             // 중복되는 단어일 경우 인덱스 차이를 구하여 answer 갱신
                answer = Math.max(i - map.get(s.charAt(i)) - 1, answer);
            } else {                                        // 처음 나온 단어는 해시맵에 등록
                map.put(s.charAt(i), i);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 62.22% of Java online submissions for Largest Substring Between Two Equal Characters.
Memory Usage: 37.1 MB, less than 31.71% of Java online submissions for Largest Substring Between Two Equal Characters.
*/
