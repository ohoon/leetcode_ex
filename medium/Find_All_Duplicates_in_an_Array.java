/*
442.
Find All Duplicates in an Array
https://leetcode.com/problems/find-all-duplicates-in-an-array/
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        boolean[] buckets = new boolean[nums.length+1];
        for (int num : nums) {
            if (buckets[num]) {     // 해당 숫자의 버켓이 이미 참이면 두 번나온 숫자이기 때문에 answer에 해당 숫자를 추가
                answer.add(num);
                continue;
            }
            
            buckets[num] = true;
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 100.00% of Java online submissions for Find All Duplicates in an Array.
Memory Usage: 48 MB, less than 68.62% of Java online submissions for Find All Duplicates in an Array.
*/
