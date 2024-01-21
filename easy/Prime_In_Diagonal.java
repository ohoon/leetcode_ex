/*
2614.
Prime In Diagonal
https://leetcode.com/problems/prime-in-diagonal/
*/

class Solution {
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= (int) Math.pow(num, 0.5); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int diagonalPrime(int[][] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (i != j && i != nums.length-j-1 && j != nums.length-i-1) {
                    continue;
                }

                set.add(nums[i][j]);
            }
        }

        for (int num : set.stream().sorted((x1, x2) -> x2.compareTo(x1)).toList()) {
            if (isPrime(num)) {
                return num;
            }
        }

        return 0;
    }
}
