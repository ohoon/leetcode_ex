/*
1679.
Max Number of K-Sum Pairs
https://leetcode.com/problems/max-number-of-k-sum-pairs/
*/

class Solution {
    public int maxOperations(int[] nums, int k) {
        int answer = 0;
        int L = 0, R = nums.length - 1;
        Arrays.sort(nums);
        while (L < R) {                     // two pointer
            int sum = nums[L] + nums[R];
            if (sum < k) {                  // 두 요소의 합이 k보다 작으면 L 포인터를, 크면 R 포인터를 이동시킴
                L++;
                continue;
            }
            
            if (sum > k) {
                R--;
                continue;
            }
            
            answer++;                       // 두 요소의 합이 k와 같으면 answer을 증가시키고 양쪽의 포인터들을 이동
            L++;
            R--;
        }
        
        return answer;
    }
}

/*
Runtime: 26 ms, faster than 78.91% of Java online submissions for Max Number of K-Sum Pairs.
Memory Usage: 72.3 MB, less than 64.90% of Java online submissions for Max Number of K-Sum Pairs.
*/
