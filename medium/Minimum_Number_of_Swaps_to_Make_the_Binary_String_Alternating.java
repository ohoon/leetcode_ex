/*
1864.
Minimum Number of Swaps to Make the Binary String Alternating
https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
*/

class Solution {
    private String createBinaryString(int start, int size) {        // start로 시작하며, 이웃한 비트의 값이 같지 않은 이진비트 문자열을 생성하는 메서드 (10101, 0101010..)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(String.valueOf((start + i) % 2));
        }
        
        return sb.toString();
    }
    
    public int minSwaps(String s) {
        int n = s.length();
        String oneStart = createBinaryString(1, n);     // 1로 시작하는 비트 문자열과 0으로 시작하는 비트 문자열 생성
        String zeroStart = createBinaryString(0, n);
        int oneStartDiff = 0, zeroStartDiff = 0, oneCount = 0, zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != oneStart.charAt(i)) {    // 위에서 생성한 최적화된 문자열과 비교해서 다른 비트의 개수를 셂
                oneStartDiff++;
            }
            
            if (s.charAt(i) != zeroStart.charAt(i)) {
                zeroStartDiff++;
            }
            
            if (s.charAt(i) == '1') {       // s에서 1과 0의 개수를 셂
                oneCount++;
            } else if (s.charAt(i) == '0') {
                zeroCount++;
            }
        }
        
        if (Math.abs(oneCount - zeroCount) > 1) {       // 1과 0의 개수가 1을 초과하면 조건에 맞는 문자열을 만들 수 없음
            return -1;
        }
        
        if (oneStartDiff % 2 != 0) {        // 최적화된 문자열과 차이점이 홀수개면 swap으로 해결할 수 없음
            return zeroStartDiff / 2;
        }
        
        if (zeroStartDiff % 2 != 0) {
            return oneStartDiff / 2;
        }
        
        return Math.min(oneStartDiff / 2, zeroStartDiff / 2);       // 보다 적게 swap하는 방법을 채택
    }
}

/*
Runtime: 8 ms, faster than 8.02% of Java online submissions for Minimum Number of Swaps to Make the Binary String Alternating.
Memory Usage: 46.6 MB, less than 5.06% of Java online submissions for Minimum Number of Swaps to Make the Binary String Alternating.
*/
