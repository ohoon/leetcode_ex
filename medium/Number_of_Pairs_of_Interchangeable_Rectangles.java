/*
2001.
Number of Pairs of Interchangeable Rectangles
https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/
*/

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long answer = 0;
        int n = rectangles.length;
        Map<Double, Integer> map = new HashMap<>();     // ratio별로 개수를 카운팅하는 해시맵
        for (int i = 0; i < n; i++) {
            double ratio = (double) rectangles[i][0] / rectangles[i][1];        // ratio
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }
        
        for (double r : map.keySet()) {             // map을 기준으로 nC2 조합을 계산
            int v = map.get(r);
            answer += (v/2.0) * (v-1);
        }
        
        return answer;
    }
}

/*
Runtime: 128 ms, faster than 12.25% of Java online submissions for Number of Pairs of Interchangeable Rectangles.
Memory Usage: 170.5 MB, less than 6.86% of Java online submissions for Number of Pairs of Interchangeable Rectangles.
*/
