/*
1995.
Count Special Quadruplets
https://leetcode.com/problems/count-special-quadruplets/
*/

class Solution {
    public int countQuadruplets(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {         // (i, j, k)의 쌍으로 target 값을 계산
                    int target = nums[i] + nums[j] + nums[k];
                    for (int l = k + 1; l < nums.length; l++) {         // k 이후의 요소 중에 target과 동일한 값이 있는지 확인하여 answer에 갱신
                        if (nums[l] == target) {
                            answer++;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 15 ms, faster than 90.21% of Java online submissions for Count Special Quadruplets.
Memory Usage: 36.7 MB, less than 95.20% of Java online submissions for Count Special Quadruplets.
*/
