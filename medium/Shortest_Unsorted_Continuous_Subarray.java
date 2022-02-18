/*
581.
Shortest Unsorted Continuous Subarray
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();        // 정렬된 배열과 원본 배열을 비교하기 위한 복제본
        int L = nums.length - 1, R = 0;
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != nums[i]) {     // 정렬되어야 하는 요소의 인덱스를 이용해서 L, R 포인터를 갱신함
                L = Math.min(L, i);         // 해당 요소가 subarray의 시작점이 될수도 있고
                R = Math.max(R, i);         // 끝점이 될 가능성이 있음
            }
        }
        
        return L < R ? R - L + 1 : 0;
    }
}

/*
Runtime: 12 ms, faster than 28.50% of Java online submissions for Shortest Unsorted Continuous Subarray.
Memory Usage: 54 MB, less than 16.52% of Java online submissions for Shortest Unsorted Continuous Subarray.
*/
