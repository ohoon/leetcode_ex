/*
609.
Find Duplicate File in System
https://leetcode.com/problems/find-duplicate-file-in-system/
*/

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String p : paths) {
            String[] split = p.split(" ");
            String dir = split[0];          // 각 path의 경로 값
            for (int i = 1; i < split.length; i++) {        // 각 path의 files 파싱하여 map에 추가
                String[] splitDetail = split[i].split("\\(");
                String file = dir + "/" + splitDetail[0];
                String content = splitDetail[1].substring(0, splitDetail[1].length()-1);
                if (map.containsKey(content)) {             // 이미 중복된 content의 file일 경우 해당 key에 해당하는 value list에 추가
                    List<String> list = map.get(content);
                    list.add(file);
                } else {                                    // 처음 나온 content의 경우에는 list의 자기 자신밖에 없음
                    List<String> newList = new ArrayList<String>();
                    newList.add(file);
                    map.put(content, newList);
                }
            }
        }
        
        for (String key : map.keySet()) {                   // value list의 길이가 2개 이상인 경우에만 answer에 넣어서 반환
            List<String> dupFiles = map.get(key);
            if (dupFiles.size() == 1) {
                continue;
            }
            
            answer.add(dupFiles);
        }
        
        return answer;
    }
}

/*
Runtime: 20 ms, faster than 38.74% of Java online submissions for Combinations.
Memory Usage: 40.6 MB, less than 32.57% of Java online submissions for Combinations.
*/
