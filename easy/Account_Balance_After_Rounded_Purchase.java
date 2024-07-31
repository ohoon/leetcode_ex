/*
2806.
Account Balance After Rounded Purchase
https://leetcode.com/problems/account-balance-after-rounded-purchase/
*/

class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundedAmount = purchaseAmount;
        if (purchaseAmount % 10 < 5) {
            roundedAmount -= purchaseAmount % 10;
        } else {
            roundedAmount += 10 - purchaseAmount % 10;
        }

        return 100 - roundedAmount;
    }
}
