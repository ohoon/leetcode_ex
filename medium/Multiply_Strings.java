/*
43.
Multiply Strings
https://leetcode.com/problems/multiply-strings/
*/

class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int[] bucket = new int[400];
        int num1Length = num1.length(), num2Length = num2.length();
        if (num1.equals("0") || num2.equals("0")) {         // 0이 있는 경우 결과는 0
            return "0";
        }
        
        for (int i = 0; i < num2Length; i++) {
            for (int j = 0; j < num1Length; j++) {
                int cur = i + j;
                bucket[cur] += (num2.charAt(num2Length-i-1) - '0') * (num1.charAt(num1Length-j-1) - '0');       // 해당 버켓에 값을 추가
                while (bucket[cur] >= 10) {                 // 올림 처리
                    bucket[cur+1] += bucket[cur] / 10;
                    bucket[cur] %= 10;
                    cur++;
                }
            }
        }
        
        for (int i = 0; i < num1Length + num2Length - 1; i++) {     // 곱셈 결과의 자리수는 num1 자리수와 num2 자리수의 합일수도 있고 1 적을수도 있음
            sb.append(bucket[i]);
        }
        
        if (bucket[num1Length+num2Length-1] > 0) {                  // 최고 자리수는 num1 자리수와 num2 자리수의 합이므로 해당 자리수에 수가 있는지 확인
            sb.append(bucket[num1Length+num2Length-1]);
        }
        
        return sb.reverse().toString();
    }
}

/*
Runtime: 5 ms, faster than 50.89% of Java online submissions for Multiply Strings.
Memory Usage: 39.1 MB, less than 60.22% of Java online submissions for Multiply Strings.
*/
