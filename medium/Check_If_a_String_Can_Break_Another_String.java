/*
1433.
Check If a String Can Break Another String
https://leetcode.com/problems/check-if-a-string-can-break-another-string/
*/

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);                    // String을 char 배열로 변환하여 a-z순으로 오름차순 정렬
        Arrays.sort(c2);
        int prev = 0;                       // 이전 알파벳 비교 결과 (0: 일치, 1: c1이 더 큼, -1: c2이 더 큼)
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c2[i]) {
                continue;
            }
            
            int curr = (c1[i] - c2[i]) / Math.abs(c1[i] - c2[i]);       // 알파벳 차이 값을 절대값으로 나눠서 -1, 0, 1형태로 나오게 최적화
            if (curr * prev < 0) {          // ex) c1[i-1] > c2[i-1]인데 c1[i] < c2[i]인 경우 break될 수 없음
                return false;
            }
            
            prev = curr;
        }
        
        return true;
    }
}

/*
Runtime: 18 ms, faster than 25.26% of Java online submissions for Check If a String Can Break Another String.
Memory Usage: 53.3 MB, less than 58.42% of Java online submissions for Check If a String Can Break Another String.
*/
