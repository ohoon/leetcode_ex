/*
2085.
Count Common Words With One Occurrence
https://leetcode.com/problems/count-common-words-with-one-occurrence/
*/

class Solution {
    private Map<String, Integer> toWordMap(String[] words) {            // String[]을 HashMap<String, Intger>으로 카운팅해주는 함수
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }

    public int countWords(String[] words1, String[] words2) {
        int answer = 0;
        Map<String, Integer> map1 = toWordMap(words1);      // 두 words 배열들을 카운팅하여 map으로 변환
        Map<String, Integer> map2 = toWordMap(words2);
        for (String key : map1.keySet()) {                  // map1을 기준으로 map2와의 공통키를 찾아서 unique한 키일때만 answer 증가
            if (map1.get(key) > 1) {
                continue;
            }

            if (!map2.containsKey(key) || map2.get(key) > 1) {
                continue;
            }

            answer++;
        }

        return answer;
    }
}

/*
Runtime: 5 ms, faster than 100.00% of Java online submissions for Count Common Words With One Occurrence.
Memory Usage: 39.5 MB, less than 90.00% of Java online submissions for Count Common Words With One Occurrence.
*/
