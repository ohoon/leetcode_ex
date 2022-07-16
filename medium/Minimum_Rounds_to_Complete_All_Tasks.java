/*
2244.
Minimum Rounds to Complete All Tasks
https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
*/

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tasks) {                           // difficulty level에 따라 카운팅
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        int answer = 0;
        for (int n : map.keySet()) {
            int count = map.get(n);
            if (count == 1) {                           // task는 한번에 2개 또는 3개만 처리 가능하므로 1개의 task만 존재하면 -1 반환하고 종료
                return -1;
            }
            
            answer += (count % 3 == 0 ? count / 3 : count / 3 + 1);
        }
        
        return answer;
    }
}

/*
Runtime: 52 ms, faster than 69.85% of Java online submissions for Minimum Rounds to Complete All Tasks.
Memory Usage: 105.8 MB, less than 48.10% of Java online submissions for Minimum Rounds to Complete All Tasks.
*/
