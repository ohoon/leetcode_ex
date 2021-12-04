/*
1329.
Sort the Matrix Diagonally
https://leetcode.com/problems/sort-the-matrix-diagonally/
*/

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();     // 우선순위큐를 이용해서 해당 대각선을 최소 힙 정렬을 수행
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                PriorityQueue<Integer> pq = map.getOrDefault(i-j, new PriorityQueue<>());       // 대각선에 있는 원소들을 묶기 위해서 i-j를 key로 지정
                pq.offer(mat[i][j]);
                if (!map.containsKey(i-j)) {
                    map.put(i-j, pq);
                }
            }
        }
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                PriorityQueue<Integer> pq = map.get(i-j);           // 우선순위 큐에서 poll하여 작은 값부터 불러와 대입시킴
                mat[i][j] = pq.poll();
            }
        }
        
        return mat;
    }
}

/*
Runtime: 9 ms, faster than 42.08% of Java online submissions for Sort the Matrix Diagonally.
Memory Usage: 40.3 MB, less than 35.62% of Java online submissions for Sort the Matrix Diagonally.
*/
