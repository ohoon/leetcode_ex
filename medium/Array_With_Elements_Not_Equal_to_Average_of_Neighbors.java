/*
1968.
Array With Elements Not Equal to Average of Neighbors
https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.sort(nums);                  // 오름차순 정렬
        for (int i = 0; i < n / 2; i++) {
            answer[2*i] = nums[i];          // [1번째로 작은 수, 1번째로 큰 수, 2번째로 작은 수, 2번째로 큰 수, ...]
            answer[2*i+1] = nums[n-i-1];
        }
        
        if (n % 2 == 1) {                   // 홀수개인 경우에는 마지막 요소를 nums의 가운데 값으로 대입
            answer[n-1] = nums[n/2];
        }
        
        return answer;
    }
}

/*
Runtime: 59 ms, faster than 11.91% of Java online submissions for Array With Elements Not Equal to Average of Neighbors.
Memory Usage: 150.7 MB, less than 10.64% of Java online submissions for Array With Elements Not Equal to Average of Neighbors.
*/
