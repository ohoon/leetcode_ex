/*
1337.
The K Weakest Rows in a Matrix
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
*/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] answer = new int[k];
        int[] counts = new int[mat.length];
        PriorityQueue<int[]> heap = new PriorityQueue<>((x1, x2) -> {           // heap을 사용하기 위한 우선순위큐
            if (x1[0] == x2[0]) {           // count값이 같으면 인덱스 기준으로
                return x1[1] - x2[1];
            }
            
            return x1[0] - x2[0];           // count값 기준으로
        });

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                
                count++;
            }
            
            counts[i] = count;
        }
        
        for (int i = 0; i < counts.length; i++) {
            heap.add(new int[]{counts[i], i});          // heap에 [count, index] 삽입
        }
        
        for (int i = 0; i < k; i++) {
            answer[i] = heap.poll()[1];                 // heap에서 최솟값 poll하여 인덱스 값을 answer에 대입
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 61.31% of Java online submissions for The K Weakest Rows in a Matrix.
Memory Usage: 39.8 MB, less than 88.34% of Java online submissions for The K Weakest Rows in a Matrix.
*/
