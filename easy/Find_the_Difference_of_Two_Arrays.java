/*
2215.
Find the Difference of Two Arrays
https://leetcode.com/problems/find-the-difference-of-two-arrays/
*/

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        Set<Integer> intersect = new HashSet<>(set1);       // set1과 set2의 교집합
        intersect.retainAll(set2);
        set1.removeAll(intersect);                          // 교집합을 제외한 부분만 남게됨
        set2.removeAll(intersect);
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(set1));
        answer.add(new ArrayList<>(set2));
        return answer;
    }
}

/*
Runtime: 25 ms, faster than 33.33% of Java online submissions for Find the Difference of Two Arrays.
Memory Usage: 55.1 MB, less than 66.67% of Java online submissions for Find the Difference of Two Arrays.
*/
