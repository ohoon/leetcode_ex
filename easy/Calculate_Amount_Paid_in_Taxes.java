/*
2303.
Calculate Amount Paid in Taxes
https://leetcode.com/problems/calculate-amount-paid-in-taxes/
*/

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int answer = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i][0] >= income) {
                answer += (income - (i > 0 ? brackets[i-1][0] : 0)) * brackets[i][1];
                break;
            }
            
            answer += (brackets[i][0] - (i > 0 ? brackets[i-1][0] : 0)) * brackets[i][1];
        }
        
        return answer / 100.0;
    }
}

/*
Runtime: 1 ms, faster than 88.89% of Java online submissions for Calculate Amount Paid in Taxes.
Memory Usage: 45.6 MB, less than 11.11% of Java online submissions for Calculate Amount Paid in Taxes.
*/
