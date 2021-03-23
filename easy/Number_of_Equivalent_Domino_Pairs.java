/*
1128.
Number of Equivalent Domino Pairs
https://leetcode.com/problems/number-of-equivalent-domino-pairs/
*/

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        for (int[] dom : dominoes) {
            if (dom[0] > dom[1]) {          // dom[0] <= dom[1]이 되도록 swap
                int temp = dom[0];
                dom[0] = dom[1];
                dom[1] = temp;
            }
            
            String key = Integer.toString(dom[0]) + Integer.toString(dom[1]);       // {1, 2} -> "12"
            if (map.containsKey(key)) {              // 이미 등록된 key의 경우
                int prev = map.get(key);
                answer += prev;
                map.put(key, prev + 1);
            } else {                                // 새로운 key의 경우
                map.put(key, 1);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 14 ms, faster than 32.10% of Java online submissions for Number of Equivalent Domino Pairs.
Memory Usage: 49 MB, less than 33.05% of Java online submissions for Number of Equivalent Domino Pairs.
*/
