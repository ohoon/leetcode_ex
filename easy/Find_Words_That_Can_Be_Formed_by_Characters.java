/*
1160.
Find Words That Can Be Formed by Characters
https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < chars.length(); i++) {          // chars에 있는 문자들의 갯수를 map에 저장
            char chr = chars.charAt(i);
            if (map.containsKey(chr)) {
                map.put(chr, map.get(chr) + 1);
            } else {
                map.put(chr, 1);
            }
        }
        
        for (int i = 0; i < words.length; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();         // temp : 임시로 사용할 map의 clone
            temp.putAll(map);
            
            String word = words[i];
            boolean pass = false;                                       // 해당 word에 chars 단어들이 모두 속하는지 검증용
            for (int j = 0; j < word.length(); j++) {
                char w = word.charAt(j);
                if (temp.containsKey(w) && temp.get(w) > 0) {           // 해당 단어 w가 temp에 하나 이상 존재하는가?
                    temp.put(w, temp.get(w) - 1);
                } else {                                                // 존재하지 않으면 pass = true
                    pass = true;
                    break;
                }
            }
            
            if (!pass) {                                                // 해당 word가 모두 chars 단어들로 이루어져 있으면 answer에 길이만큼 더함
                answer += word.length();
            }
        }
        
        return answer;
    }
}

/*
Runtime: 28 ms, faster than 47.01% of Java online submissions for Find Words That Can Be Formed by Characters.
Memory Usage: 40.1 MB, less than 25.01% of Java online submissions for Find Words That Can Be Formed by Characters.
*/

/*
여담

python으로 코딩 문제를 풀다가 java로 푸니 불편한점이 많다.
hashmap key에 primitive한 타입은 넣을 수가 없어서 String에서 charAt으로 주입해줘야 했음
처음이라 모르다보니 많이 헤매서 시간을 좀 소비한듯

*/
