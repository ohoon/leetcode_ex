/*
2600.
K Items With the Maximum Sum
https://leetcode.com/problems/k-items-with-the-maximum-sum/
*/

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int answer = 0;
        if (k <= numOnes) {
            return k;
        }

        answer += numOnes;
        k -= numOnes + numZeros;
        if (k <= 0) {
            return answer;
        }

        return answer - k;
    }
}
