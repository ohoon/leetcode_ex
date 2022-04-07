/*
2091.
Removing Minimum and Maximum From Array
https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
*/

class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int iMax = 0, iMin = 0;         // 최대값과 최소값의 인덱스
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[iMax]) {
                iMax = i;
                continue;
            }
            
            if (nums[i] < nums[iMin]) {
                iMin = i;
            }
        }
        
        int answer = Integer.MAX_VALUE;
        int left = Math.min(iMax, iMin);        // iMax와 iMin 중에 상대적으로 작은 인덱스
        int right = Math.max(iMax, iMin);       // iMax와 iMin 중에 상대적으로 큰 인덱스
        answer = Math.min(answer, right + 1);   // 0 ~ right의 요소를 제거할 경우
        answer = Math.min(answer, n - left);    // left ~ n-1의 요소를 제거할 경우
        answer = Math.min(answer, left - right + n + 1);    // 0 ~ left와 right ~ n-1의 요소를 제거할 경우
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 66.99% of Java online submissions for Removing Minimum and Maximum From Array.
Memory Usage: 85 MB, less than 31.04% of Java online submissions for Removing Minimum and Maximum From Array.
*/
