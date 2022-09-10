/*
2396.
Strictly Palindromic Number
https://leetcode.com/problems/strictly-palindromic-number/
*/

class Solution {
    private boolean isPalindromic(int n, int x) {       // palindromic한지 검사하는 메서드
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % x);
            n /= x;
        }
        
        int len = list.size();
        for (int i = 0; i < len / 2; i++) {
            if (list.get(i) != list.get(len-i-1)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n-2; i++) {
            if (!isPalindromic(n, i)) {
                return false;
            }
        }
        
        return true;
    }
}

/*
Runtime: 1 ms, faster than 44.51% of Java online submissions for Strictly Palindromic Number.
Memory Usage: 40.3 MB, less than 87.16% of Java online submissions for Strictly Palindromic Number.
*/
