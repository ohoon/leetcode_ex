/*
2161.
Partition Array According to Given Pivot
https://leetcode.com/problems/partition-array-according-to-given-pivot/
*/

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();     // pivot보다 작은 요소 리스트
        List<Integer> center = new ArrayList<>();   // pivot과 같은 요소 리스트
        List<Integer> right = new ArrayList<>();    // pivot보다 큰 요소 리스트
        for (int num : nums) {
            if (num < pivot) {
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                center.add(num);
            }
        }
        
        List<Integer> answer = new ArrayList<>();       // answer에 위에서 pivot에 따라 분할한 리스트들을 합침
        answer.addAll(left);
        answer.addAll(center);
        answer.addAll(right);
        return answer.stream().mapToInt(v -> v).toArray();
    }
}

/*
Runtime: 44 ms, faster than 5.17% of Java online submissions for Partition Array According to Given Pivot.
Memory Usage: 173.1 MB, less than 5.27% of Java online submissions for Partition Array According to Given Pivot.
*/
