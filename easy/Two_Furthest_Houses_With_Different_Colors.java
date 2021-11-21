/*
2078.
Two Furthest Houses With Different Colors
https://leetcode.com/problems/two-furthest-houses-with-different-colors/
*/

class Solution {
    public int maxDistance(int[] colors) {
        int L = 0, R = colors.length - 1;       // two pointer
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            if (colors[0] != colors[n-i-1] || colors[n-1] != colors[i]) {       // 양 끝의 요소와 각 포인터들을 비교해서 최적의 해를 구함
                return n-i-1;
            }
        }
        
        return 0;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Furthest Houses With Different Colors.
Memory Usage: 36.9 MB, less than 37.50% of Java online submissions for Two Furthest Houses With Different Colors.
*/
