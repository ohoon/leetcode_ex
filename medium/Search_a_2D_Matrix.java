/*
74.
Search a 2D Matrix
https://leetcode.com/problems/search-a-2d-matrix/
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] firstRows = new int[matrix.length];               // 첫 행의 요소들을 복사하여 1차원 배열로 배치
        for (int i = 0; i < matrix.length; i++) {
            firstRows[i] = matrix[i][0];
        }
        
        int r = binarySearch(firstRows, target);                // 첫 행 요소들을 이진 탐색하여 탐색할 행 인덱스를 찾음
        if (r < 0) {                                            // 첫 행 첫 열의 요소보다 타겟이 작으면 타겟은 존재할 수 없음
            return false;
        }
        
        int c = binarySearch(matrix[r], target);                // 해당 행의 첫 열의 요소보다 타겟이 작으면 타겟은 존재할 수 없음
        if (c < 0) {
            return false;
        }
        
        return matrix[r][c] == target;                          // 찾은 위치의 요소가 타겟인지 검사
    }
    
    private int binarySearch(int[] arr, int target) {           // 이진 탐색 함수
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
Memory Usage: 38.7 MB, less than 24.21% of Java online submissions for Search a 2D Matrix.
*/
