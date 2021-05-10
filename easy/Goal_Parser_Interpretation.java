/*
1678.
Goal Parser Interpretation
https://leetcode.com/problems/goal-parser-interpretation/
*/

class Solution {
    public String interpret(String command) {
        Map<String, String> map = new HashMap<>();          // 매칭맵 세팅
        map.put("G", "G");
        map.put("()", "o");
        map.put("(al)", "al");
        
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 1; i <= command.length(); i++) {
            String code = command.substring(start, i);
            if (map.containsKey(code)) {                    // 코드가 매칭맵에 해당되면
                sb.append(map.get(code));                   // 복호화된 문자열을 sb에 추가하고 start 포인트 갱신
                start = i;
            }
        }
        
        return sb.toString();
    }
}

/*
Runtime: 1 ms, faster than 59.89% of Java online submissions for Goal Parser Interpretation.
Memory Usage: 37.4 MB, less than 38.83% of Java online submissions for Goal Parser Interpretation.
*/
