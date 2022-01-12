/*
1282.
Group the People Given the Group Size They Belong To
https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
*/

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();      // size별로 index group를 관리하는 hashmap
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> group;
            int size = groupSizes[i];
            if (!map.containsKey(size)) {
                group = new ArrayList<>();
                group.add(i);
                map.put(size, group);
            } else {
                group = map.get(size);
                group.add(i);
            }
            
            if (group.size() == size) {                 // group이 완성되면 answer에 삽입하고 해당 group을 초기화
                answer.add(new ArrayList<>(group));
                group.clear();
            }
        }
        
        return answer;
    }
}

/*
Runtime: 6 ms, faster than 56.85% of Java online submissions for Group the People Given the Group Size They Belong To.
Memory Usage: 49.6 MB, less than 37.49% of Java online submissions for Group the People Given the Group Size They Belong To.
*/
