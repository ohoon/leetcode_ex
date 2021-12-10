/*
939.
Minimum Area Rectangle
https://leetcode.com/problems/minimum-area-rectangle/
*/

class Solution {
    public int minAreaRect(int[][] points) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();       // x값을 key로, y값들을 set형태로 가지는 map
        for (int[] p : points) {                                // 각 좌표들을 map에다가 등록
            if (map.containsKey(p[0])) {
                Set<Integer> set = map.get(p[0]);
                set.add(p[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(p[1]);
                map.put(p[0], set);
            }
        }
        
        for (int i = 0; i < points.length - 1; i++) {           // 좌표들 중에 두 점을 가지고 작업
            for (int j = 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 || y1 == y2) {                     // ㅣ이나 ㅡ처럼 위치한 두 점일 경우 패스
                    continue;
                }
                
                if (!map.get(x1).contains(y2) || !map.get(x2).contains(y1)) {       // 사각형을 만들기 위한 다른 두 점이 없으면 패스
                    continue;
                }
                
                int area = Math.abs(x1-x2) * Math.abs(y1-y2);           // 넓이 계산
                answer = Math.min(answer, area);
            }
        }
        
        return answer != Integer.MAX_VALUE ? answer : 0;
    }
}

/*
Runtime: 357 ms, faster than 47.81% of Java online submissions for Minimum Area Rectangle.
Memory Usage: 39.8 MB, less than 38.95% of Java online submissions for Minimum Area Rectangle.
*/
