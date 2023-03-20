/*
2591.
Distribute Money to Maximum Children
https://leetcode.com/problems/distribute-money-to-maximum-children/
*/

class Solution {
    public int distMoney(int money, int children) {
        if (children > money) {
            return -1;
        }

        if (money < 8) {
            return 0;
        }

        money -= children;
        int q = money / 7;
        int r = money % 7;
        if (q == children && r == 0) {
            return children;
        }

        if (q >= children) {
            return children - 1;
        }

        if (q == children - 1 && r == 3) {
            return children - 2;
        }

        return q;
    }
}
