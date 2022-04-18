/*
2239.
Find Closest Number to Zero
https://leetcode.com/problems/find-closest-number-to-zero/
*/

class Solution {
    public int findClosestNumber(int[] nums) {
        int answer = nums[0];
        for (int num : nums) {
            int ans = Math.abs(answer - 0);     // answer이 0에 가까운 정도
            int curr = Math.abs(num - 0);       // num이 0에 가까운 정도
            if (ans == curr) {                  // 같으면 큰 정수를 answer로
                answer = Math.max(answer, num);
                continue;
            }
            
            if (ans > curr) {                   // 더 가까우면 answer 갱신
                answer = num;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 50.00% of Java online submissions for Find Closest Number to Zero.
Memory Usage: 42.1 MB, less than 83.33% of Java online submissions for Find Closest Number to Zero.
*/
