/*
49.
Group Anagrams
https://leetcode.com/problems/group-anagrams/
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {     // 각 요소를 정렬하여 map에 인덱스 등록
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            
            map.get(key).add(i);
        }
        
        for (String key : map.keySet()) {           // map에 있는 인덱스끼리 묶어서 answer에 추가
            List<String> group = new ArrayList<>();
            for (int i : map.get(key)) {
                group.add(strs[i]);
            }
            
            answer.add(group);
        }
        
        return answer;
    }
}

/*
Runtime: 7 ms, faster than 55.82% of Java online submissions for Group Anagrams.
Memory Usage: 43.5 MB, less than 27.73% of Java online submissions for Group Anagrams.
*/

/*
다른 사람의 풀이

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String,List<String>> map = new HashMap<>();
            for(String str : strs){
                char[] c= str.toCharArray();
                Arrays.sort(c);
                String temp = Arrays.toString(c);
                if(!map.containsKey(temp)){
                    map.put(temp,new LinkedList<>());
                }
                map.get(temp).add(str);
            }

             return new ArrayList<>(map.values());
    }
}

인덱스만 옮겨서 나중에 다시 리스트에 삽입하는 것이 아니라
map에서 바로 문자열을 넣는 식으로 풀이한 코드다.
확실히 2-pass할 필요가 없기 때문에 효율적으로 잘 짠 코드라고 생각한다.

*/
