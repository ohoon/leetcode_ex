/*
833.
Find And Replace in String
https://leetcode.com/problems/find-and-replace-in-string/
*/

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {      // indice를 key로, [source, target]을 value로 하도록 map을 설계
            map.put(indices[i], new Pair(sources[i], targets[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(i)) {                   // indice에 해당하는 인덱스일 경우
                Pair p = map.get(i);
                String source = (String) p.getKey();
                String target = (String) p.getValue();
                if (source.equals(s.substring(i, i + source.length()))) {       // 해당 indice에 위치한 문자열이 source와 일치할 때 target을 stringbulder에 삽입하고 인덱스 수정
                    sb.append(target);
                    i += source.length() - 1;
                    continue;
                }
            }
            
            sb.append(s.charAt(i));         // 그 외의 문자열들은 그대로 stringbuilder에 삽입
        }
        
        return sb.toString();
    }
}

/*
Runtime: 2 ms, faster than 67.01% of Java online submissions for Find And Replace in String.
Memory Usage: 39.2 MB, less than 56.93% of Java online submissions for Find And Replace in String.
*/
