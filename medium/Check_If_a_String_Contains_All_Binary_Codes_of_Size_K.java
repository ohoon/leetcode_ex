/*
1461.
Check If a String Contains All Binary Codes of Size K
https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
*/

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int remain = (int) Math.pow(2, k);      // k비트로 만들 수 있는 숫자의 남은 개수
        Set<String> set = new HashSet<>();      // substring한 2진수 문자열들을 저장하는 set
        for (int i = 0; i <= s.length() - k; i++) {
            String bin = s.substring(i, i+k);
            if (set.contains(bin)) {            // 중복되는 숫자들은 처리하지 않음
                continue;
            }
            
            set.add(bin);
            if (--remain == 0) {                // k비트의 모든 숫자들을 만들 수 있으면 true 반환
                return true;
            }
        }
        
        return remain == 0;
    }
}

/*
Runtime: 232 ms, faster than 11.17% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
Memory Usage: 126.6 MB, less than 5.03% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
*/
