/*
1576.
Replace All ?'s to Avoid Consecutive Repeating Characters
https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
*/

class Solution {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {                                   // ?인 경우에만 새로운 알파벳 삽입
                for (char alpha = 'a'; alpha <= 'z'; alpha++) {             // a~z까지 비교
                    if ((i == 0 || sb.charAt(i-1) != alpha) && (i == s.length() - 1 || s.charAt(i+1) != alpha)) {
                        sb.append(alpha);                               // 앞 문자 비교는 stringbuilder에서, 뒷 문자 비교는 원래 문자열 s에서 비교함
                        break;
                    }
                }
            } else {                                                    // 원래 문자열의 알파벳 삽입
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
Memory Usage: 38.7 MB, less than 92.59% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
*/
