/*
986.
Interval List Intersections
https://leetcode.com/problems/interval-list-intersections/
*/

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> answer = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);        // 공통 부분을 찾기 위해선 start 지점은 보다 크고,
            int end = Math.min(firstList[i][1], secondList[j][1]);          // end 지점은 보다 작아야 함
            if (start <= end) {
                answer.add(new int[]{start, end});
            }
            
            if (firstList[i][1] < secondList[j][1]) {       // end 지점이 작은 요소부터 인덱스를 이동
                i++;
            } else {
                j++;
            }
        }
        
        return answer.toArray(new int[answer.size()][2]);
    }
}

/*
Runtime: 5 ms, faster than 59.46% of Java online submissions for Interval List Intersections.
Memory Usage: 54.5 MB, less than 62.17% of Java online submissions for Interval List Intersections.
*/
