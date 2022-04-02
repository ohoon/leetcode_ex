/*
1838.
Frequency of the Most Frequent Element
https://leetcode.com/problems/frequency-of-the-most-frequent-element/
*/

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int answer = 1;
        int n = nums.length;
        int L = 0, sum = 0;
        Arrays.sort(nums);
        for (int R = 0; R < n; R++) {       // sliding window
            sum += nums[R];
            while (nums[R] * (R-L+1) - sum > k) {       // nums[R] * L과 R사이의 거리 - sum = nums[R]로 통일하기 위해 필요한 operation 개수
                sum -= nums[L++];                       // operation 개수가 k 이하가 될 때까지 L포인터를 이동시킴
            }
            
            answer = Math.max(answer, R-L+1);
        }
        
        return answer;
    }
}

/*
Runtime: 36 ms, faster than 66.15% of Java online submissions for Frequency of the Most Frequent Element.
Memory Usage: 95.6 MB, less than 70.77% of Java online submissions for Frequency of the Most Frequent Element.
*/
