/*
2032.
Two Out of Three
https://leetcode.com/problems/two-out-of-three/
*/

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> answer = new ArrayList<>();
        boolean[] b1 = new boolean[101];
        boolean[] b2 = new boolean[101];
        boolean[] b3 = new boolean[101];
        for (int n : nums1) {
            b1[n] = true;
        }
        
        for (int n : nums2) {
            b2[n] = true;
        }
        
        for (int n : nums3) {
            b3[n] = true;
        }
        
        for (int i = 1; i < 101; i++) {
            if ((b1[i] && b2[i]) || (b1[i] && b3[i]) || (b2[i] && b3[i])) {
                answer.add(i);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 98.67% of Java online submissions for Two Out of Three.
Memory Usage: 39.8 MB, less than 88.96% of Java online submissions for Two Out of Three.
*/
