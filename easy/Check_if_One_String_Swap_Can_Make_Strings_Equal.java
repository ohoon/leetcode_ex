/*
1790.
Check if One String Swap Can Make Strings Equal
https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
*/

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> notEquals = new ArrayList<>();        // s1와 s2와 서로 다른 문자가 나오는 인덱스 값 목록
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (notEquals.size() > 1) {                 // 한 쌍 이상의 다른점이 발견되면 false
                    return false;
                }

                notEquals.add(i);
            }
        }

        if (notEquals.size() == 0) {                        // 이미 일치하므로 true
            return true;
        }

        if (notEquals.size() == 1) {                        // 쌍이 맞춰지지 않으므로 false
            return false;
        }

        return s1.charAt(notEquals.get(0)) == s2.charAt(notEquals.get(1)) &&        // 각각 다른 인덱스가 가리키는 값끼리 비교
                s1.charAt(notEquals.get(1)) == s2.charAt(notEquals.get(0));
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if One String Swap Can Make Strings Equal.
Memory Usage: 36.9 MB, less than 89.26% of Java online submissions for Check if One String Swap Can Make Strings Equal.
*/
