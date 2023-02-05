/*
2553.
Separate the Digits in an Array
https://leetcode.com/problems/separate-the-digits-in-an-array/
*/

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for (int num : nums) {
            String numStr = String.valueOf(num);
            for (char digit : numStr.toCharArray()) {
                answer.add(digit-'0');
            }
        }

        return answer.stream().mapToInt(v->v).toArray();
    }
}
