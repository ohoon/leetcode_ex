/*
1313.
Decompress Run-Length Encoded List
https://leetcode.com/problems/decompress-run-length-encoded-list/
*/

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i += 2) {          // answer 배열의 전체 크기 측정
            size += nums[i];
        }
        
        int[] answer = new int[size];                       // 배열 초기화
        int cur = 0;                                        // fill로 채울 인덱스 시작위치
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i+1];
            Arrays.fill(answer, cur, cur + freq, val);      // cur부터 freq 개수만큼 val 값으로 배열을 채움
            cur += freq;                                    // cur 인덱스 갱신
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
Memory Usage: 39.6 MB, less than 55.96% of Java online submissions for Decompress Run-Length Encoded List.
*/
