/*
2176.
Count Equal and Divisible Pairs in an Array
https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
*/

class Solution {
    public int countPairs(int[] nums, int k) {
        int answer = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {       // 같지 않으면 패스
                    continue;
                }
                
                if ((i * j) % k > 0) {          // k 조건을 성립하지 않으면 패스
                    continue;
                }
                
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 100.00% of Java online submissions for Count Equal and Divisible Pairs in an Array.
Memory Usage: 41.4 MB, less than 28.57% of Java online submissions for Count Equal and Divisible Pairs in an Array.
*/
