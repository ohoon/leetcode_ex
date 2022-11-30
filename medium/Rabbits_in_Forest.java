/*
781.
Rabbits in Forest
https://leetcode.com/problems/rabbits-in-forest/
*/

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();        // 카운팅
        for (int n : answers) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int answer = 0;
        for (int n : map.keySet()) {
            answer += (n + 1) * Math.ceil(map.get(n) / (n + 1.0));      // 본인 제외 n명이므로 n+1, 개수가 넘치는 경우에는 새로운 색을 기준으로
        }

        return answer;
    }
}
