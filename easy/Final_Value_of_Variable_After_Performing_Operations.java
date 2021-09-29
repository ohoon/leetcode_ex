/*
2011.
Final Value of Variable After Performing Operations
https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
*/

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (String op : operations) {
            if (op.contains("++")) {
                X++;
            } else {
                X--;
            }
        }
        
        return X;
    }
}

/*
Runtime: 1 ms, faster than 81.28% of Java online submissions for Final Value of Variable After Performing Operations.
Memory Usage: 38.5 MB, less than 80.30% of Java online submissions for Final Value of Variable After Performing Operations.
*/
