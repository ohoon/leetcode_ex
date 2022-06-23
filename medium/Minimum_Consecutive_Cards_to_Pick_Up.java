/*
2260.
Minimum Consecutive Cards to Pick Up
https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
*/

class Solution {
    public int minimumCardPickup(int[] cards) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {            // 이전에 나온 인덱스가 존재하면
                answer = Math.min(answer, i - map.get(cards[i]) + 1);       // 두 요소의 거리만큼 answer 갱신
            }
            
            map.put(cards[i], i);       // 해시맵의 인덱스 갱신
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}

/*
Runtime: 108 ms, faster than 47.68% of Java online submissions for Minimum Consecutive Cards to Pick Up.
Memory Usage: 148.2 MB, less than 48.72% of Java online submissions for Minimum Consecutive Cards to Pick Up.
*/
