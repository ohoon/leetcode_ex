/*
2200.
Find All K-Distant Indices in an Array
https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
*/

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new TreeSet<>();         // index들이 오름차순으로 정렬되어야 하므로 treeset을 사용
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != key) {
                continue;
            }
            
            for (int j = i-k; j <= i+k; j++) {      // nums[i] == key일 때, i-k ~ i+k의 인덱스를 set에 삽입
                if (j < 0 || j >= nums.length) {    // 가능한 인덱스 범위를 벗어날 경우 작업하지 않음
                    continue;
                }
                
                set.add(j);
            }
        }
        
        return new ArrayList<>(set);
    }
}

/*
Runtime: 388 ms, faster than 33.33% of Java online submissions for Find All K-Distant Indices in an Array.
Memory Usage: 43 MB, less than 100.00% of Java online submissions for Find All K-Distant Indices in an Array.
*/
