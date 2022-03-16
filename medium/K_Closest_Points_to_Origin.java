/*
973.
K Closest Points to Origin
https://leetcode.com/problems/k-closest-points-to-origin/
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];
        Arrays.sort(points, (x, y) -> x[0]*x[0]+x[1]*x[1]-y[0]*y[0]-y[1]*y[1]);     // 원점으로부터 가까운 점이 앞으로 오도록 오름차순 정렬
        for (int i = 0; i < k; i++) {       // 제일 가까운 k개의 점을 answer에 대입
            answer[i] = points[i];
        }
        
        return answer;
    }
}

/*
Runtime: 34 ms, faster than 73.56% of Java online submissions for K Closest Points to Origin.
Memory Usage: 116.6 MB, less than 44.36% of Java online submissions for K Closest Points to Origin.
*/
