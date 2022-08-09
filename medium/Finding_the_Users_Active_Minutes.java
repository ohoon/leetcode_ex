/*
1817.
Finding the Users Active Minutes
https://leetcode.com/problems/finding-the-users-active-minutes/
*/

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();       // id별로 중복되는 minute를 처리하기 위해 set로 관리
        for (int[] log : logs) {
            if (map.containsKey(log[0])) {
                map.get(log[0]).add(log[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(log[1]);
                map.put(log[0], set);
            }
        }
        
        int[] answer = new int[k];
        for (int id : map.keySet()) {
            answer[map.get(id).size()-1]++;
        }
        
        return answer;
    }
}

/*
Runtime: 47 ms, faster than 26.16% of Java online submissions for Finding the Users Active Minutes.
Memory Usage: 98.7 MB, less than 84.79% of Java online submissions for Finding the Users Active Minutes.
*/
