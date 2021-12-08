/*
1750.
Minimum Length of String After Deleting Similar Ends
https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
*/

class Solution {
    public int minimumLength(String s) {
        int L = 0, R = s.length() - 1;      // two pointer
        while (L < R && s.charAt(L) == s.charAt(R)) {               // prefix와 suffix가 같을때까지 반복
            while (L+1 < R && s.charAt(L+1) == s.charAt(L)) {       // 다른 문자가 나올때까지 L포인터 이동
                L++;
            }

            while (L < R-1 && s.charAt(R-1) == s.charAt(R)) {       // 다른 문자가 나올때까지 R포인터 이동
                R--;
            }

            L++;        // 다음 문자로 L, R포인터를 이동
            R--;
        }

        return R - L + 1;
    }
}

/*
Runtime: 14 ms, faster than 8.85% of Java online submissions for Minimum Length of String After Deleting Similar Ends.
Memory Usage: 49.3 MB, less than 21.92% of Java online submissions for Minimum Length of String After Deleting Similar Ends.
*/
