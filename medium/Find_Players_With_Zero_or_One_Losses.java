/*
2225.
Find Players With Zero or One Losses
https://leetcode.com/problems/find-players-with-zero-or-one-losses/
*/

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new TreeMap<>();        // player를 오름차순으로 삽입하기 위해 treemap 사용
        for (int[] m : matches) {
            if (!map.containsKey(m[0])) {
                map.put(m[0], 0);
            }
            
            map.put(m[1], map.getOrDefault(m[1], 0) + 1);
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        for (int player : map.keySet()) {
            if (map.get(player) == 0) {         // 패배 횟수에 따라 다른 위치에 삽입
                answer.get(0).add(player);
                continue;
            }
            
            if (map.get(player) == 1) {
                answer.get(1).add(player);
                continue;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 580 ms, faster than 13.08% of Java online submissions for Find Players With Zero or One Losses.
Memory Usage: 143.4 MB, less than 71.76% of Java online submissions for Find Players With Zero or One Losses.
*/
