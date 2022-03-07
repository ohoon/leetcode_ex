/*
2190.
Most Frequent Number Following Key In an Array
https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/
*/

class Solution {
    public int mostFrequent(int[] nums, int key) {
        int answer = 0, maxCount = 0;
        int[] count = new int[1001];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != key) {
                continue;
            }
            
            if (++count[nums[i+1]] > maxCount) {        // target 카운팅한 값이 maxCount보다 크면 answer과 maxCount 갱신
                answer = nums[i+1];
                maxCount = count[nums[i+1]];
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Most Frequent Number Following Key In an Array.
Memory Usage: 46.7 MB, less than 14.29% of Java online submissions for Most Frequent Number Following Key In an Array.
*/
