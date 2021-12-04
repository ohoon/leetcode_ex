/*
2089.
Find Target Indices After Sorting Array
https://leetcode.com/problems/find-target-indices-after-sorting-array/
*/

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {        // target을 만나면 해당 인덱스를 answer에 삽입
                answer.add(i);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 85.71% of Java online submissions for Find Target Indices After Sorting Array.
Memory Usage: 39.4 MB, less than 42.86% of Java online submissions for Find Target Indices After Sorting Array.
*/
