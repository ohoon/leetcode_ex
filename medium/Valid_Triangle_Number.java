/*
611.
Valid Triangle Number
https://leetcode.com/problems/valid-triangle-number/
*/

class Solution {
    public int triangleNumber(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);      // 오름차순 정렬
        for (int i = 0; i < nums.length - 2; i++) {         // 빗변 nums[i]와 nums[j]를 먼저 고름
            if (nums[i] == 0) {
                continue;
            }
            
            int k = i + 2;      // 밑변 nums[k]
            for (int j = i+1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                while (k < nums.length && nums[k] < sum) {  // 삼각형이 되기 위해서는 두 빗변의 길이 합이 밑변의 길이보다 커야함
                    k++;
                }
                
                answer += k - j - 1;        // j+1 ~ k-1의 요소들은 밑변이 될 수 있음
            }
        }
        
        return answer;
    }
}

/*
Runtime: 49 ms, faster than 43.56% of Java online submissions for Valid Triangle Number.
Memory Usage: 44 MB, less than 43.15% of Java online submissions for Valid Triangle Number.
*/
