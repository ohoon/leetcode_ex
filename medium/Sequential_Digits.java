/*
1291.
Sequential Digits
https://leetcode.com/problems/sequential-digits/
*/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> answer = new ArrayList<>();
        String digit = "123456789";                 // 연속된 숫자인 digit을 기준으로 탐색
        int lowSize = String.valueOf(low).length();     // low의 숫자 길이
        int highSize = String.valueOf(high).length();   // high의 숫자 길이
        for (int i = lowSize; i <= highSize; i++) {
            for (int j = i; j < 10; j++) {
                int num = Integer.valueOf(digit.substring(j - i, j));
                if (num >= low && num <= high) {
                    answer.add(num);
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Sequential Digits.
Memory Usage: 39.5 MB, less than 95.94% of Java online submissions for Sequential Digits.
*/
