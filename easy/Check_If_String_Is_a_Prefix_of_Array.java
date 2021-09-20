'''
1961.
Check If String Is a Prefix of Array
https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
'''

class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int cur = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (cur >= s.length() || s.charAt(cur) != words[i].charAt(j)) {     // 각 word 도중에 s가 완성되거나 prefix가 성립하지 않으면 종료하고 false 반환
                    return false;
                }
                
                cur++;
            }
            
            if (cur >= s.length()) {        // word 단위로 s가 완성되면 true 반환
                return true;
            }
        }
        
        return false;       // words로는 s를 만들 수 없으면 false 반환
    }
}

'''
Runtime: 1 ms, faster than 93.97% of Java online submissions for Check If String Is a Prefix of Array.
Memory Usage: 38.9 MB, less than 91.05% of Java online submissions for Check If String Is a Prefix of Array.
'''
