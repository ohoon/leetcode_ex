/*
2389.
Longest Subsequence With Limited Sum
https://leetcode.com/problems/longest-subsequence-with-limited-sum/
*/

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {     // greedy
        int[] answer = new int[queries.length];
        Arrays.sort(nums);                          // 값이 작은 것부터 사용하기 위해 오름차순 정렬
        for (int i = 0; i < queries.length; i++) {
            int sum = 0, index = 0;
            while (sum <= queries[i] && index < nums.length) {
                sum += nums[index++];
            }
            
            answer[i] = sum <= queries[i] ? index : index-1;
        }
        
        return answer;
    }
}

/*
Runtime: 9 ms, faster than 40.00% of Java online submissions for Longest Subsequence With Limited Sum.
Memory Usage: 48.5 MB, less than 40.00% of Java online submissions for Longest Subsequence With Limited Sum.
*/
