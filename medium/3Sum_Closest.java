/*
16.
3Sum Closest
https://leetcode.com/problems/3sum-closest/
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int result;
            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                result = nums[i] + nums[L] + nums[R];
                if (result == target) {
                    return result;
                } else if (result > target) {       // target보다 크면 R를 감소
                    R--;
                } else {                            // target보다 작으면 L을 증가
                    L++;
                }
                
                if (Math.abs(result - target) < Math.abs(answer - target)) {
                    answer = result;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 86.56% of Java online submissions for 3Sum Closest.
Memory Usage: 38.4 MB, less than 89.13% of Java online submissions for 3Sum Closest.
*/
