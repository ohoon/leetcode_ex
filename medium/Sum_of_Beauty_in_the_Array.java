/*
2012.
Sum of Beauty in the Array
https://leetcode.com/problems/sum-of-beauty-in-the-array/
*/

class Solution {
    public int sumOfBeauties(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int[] max = new int[n];     // 0~i까지의 최대값을 기록하는 배열
        int[] min = new int[n];     // i~n까지의 최소값을 기록하는 배열
        max[0] = nums[0];           // max와 min 배열의 초기값을 설정
        min[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i-1], nums[i]);
        }
        
        for (int i = n-2; i >= 0; i--) {
            min[i] = Math.min(min[i+1], nums[i]);
        }
        
        for (int i = 1; i < n-1; i++) {
            if (nums[i-1] >= nums[i] || nums[i] >= nums[i+1]) {     // 양 옆의 요소가 조건에 부합하지 않으면 beauty값은 0
                continue;
            }
            
            answer++;                                               // 1이 될 조건은 성립되므로 1 올려줌
            if (max[i-1] >= nums[i] || nums[i] >= min[i+1]) {       // 2가 되기 위해서 0~(i-1)까지의 최대값이 nums[i]보다 작고 (i+1)~n까지의 최소값이 nums[i]보다 커야함
                continue;
            }
            
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 6 ms, faster than 60.74% of Java online submissions for Sum of Beauty in the Array.
Memory Usage: 55.4 MB, less than 44.58% of Java online submissions for Sum of Beauty in the Array.
*/
