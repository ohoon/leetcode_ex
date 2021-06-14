/*
1893.
Check if All the Integers in a Range Are Covered
https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/
*/

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] bucket = new int[52];         // bucket
        
        for (int[] range : ranges) {
            bucket[range[0]]++;             // 범위 별로 시작지와 끝지점을 표시
            bucket[range[1]+1]--;
        }
        
        for (int i = 1; i < 51; i++) {      // 시작지부터 끝지점까지는 +1이 됨
            bucket[i] += bucket[i-1];
        }
        
        for (int i = left; i <= right; i++) {
            if (bucket[i] == 0) {           // 커버되지 않은 버켓일시 false 반환
                return false;
            }
        }
        
        return true;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if All the Integers in a Range Are Covered.
Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Check if All the Integers in a Range Are Covered.
*/
