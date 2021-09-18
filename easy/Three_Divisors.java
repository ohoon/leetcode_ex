'''
1952.
Three Divisors
https://leetcode.com/problems/three-divisors/
'''

import java.lang.Math;

class Solution {
    public boolean isThree(int n) {
        int loot = (int) Math.sqrt(n);
        if (n < 2 || loot * loot != n) {        // n이 1이거나 제곱수가 아니면 성립하지 않음
            return false;
        }
        
        for (int i = 2; i < loot; i++) {        // loot를 제외한 다른 수로 나뉘어지면 divisor이 3개 초과가 되므로 성립하지 않음
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

'''
Runtime: 0 ms, faster than 100.00% of Java online submissions for Three Divisors.
Memory Usage: 35.8 MB, less than 69.35% of Java online submissions for Three Divisors.
'''
