/*
451.
Sort Characters By Frequency
https://leetcode.com/problems/sort-characters-by-frequency/
*/

class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);         // 카운팅하여 map에 저장
        }
        
        List<Character> list = new ArrayList<>(map.keySet()).stream()       // map에 key값들을 빈도수 내림차순으로 정렬하여 리스트화
            .sorted((x, y) -> (map.get(y) - map.get(x)))
            .collect(Collectors.toList());
        
        for (char c : list) {
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);           // 해당 key의 빈도수만큼 stringbuilder에 append
            }
        }
        
        return sb.toString();
    }
}

/*
Runtime: 13 ms, faster than 57.73% of Java online submissions for Sort Characters By Frequency.
Memory Usage: 39.7 MB, less than 79.57% of Java online submissions for Sort Characters By Frequency.
*/
