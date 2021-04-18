/*
1437.
Check If All 1's Are at Least Length K Places Away
https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
*/

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;          // 최근 1bit의 인덱스
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && (i - prev - 1) < k) {     // 이전의 1bit와 현재 1bit의 인덱스 차이가 k보다 작으면 false
                    return false;
                }
                
                prev = i;           // prev 갱신
            }
            
        }
        
        return true;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Check If All 1's Are at Least Length K Places Away.
Memory Usage: 48.9 MB, less than 49.55% of Java online submissions for Check If All 1's Are at Least Length K Places Away.
*/
