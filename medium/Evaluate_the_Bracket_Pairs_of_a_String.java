/*
1807.
Evaluate the Bracket Pairs of a String
https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
*/

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {      // knowledge에 있는 키워드를 map에 저장
            map.put(k.get(0), k.get(1));
        }
        
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while (cur < s.length()) {
            if (s.charAt(cur) == '(') {         // (keyword)가 발견되면 map을 참조
                int next = cur;
                while (s.charAt(next) != ')') {
                    next++;
                }
                
                sb.append(map.getOrDefault(s.substring(cur + 1, next), "?"));       // map에 없는 키워드면 ?으로 대체하여 삽입
                cur = next + 1;
                continue;
            }
            
            sb.append(s.charAt(cur++));         // 기본 알파벳은 그대로 stringbuilder에 삽입
        }
        
        return sb.toString();
    }
}

/*
Runtime: 68 ms, faster than 57.56% of Java online submissions for Evaluate the Bracket Pairs of a String.
Memory Usage: 91.9 MB, less than 76.74% of Java online submissions for Evaluate the Bracket Pairs of a String.
*/
