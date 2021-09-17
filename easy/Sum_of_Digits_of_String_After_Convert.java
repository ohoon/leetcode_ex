'''
1945.
Sum of Digits of String After Convert
https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
'''

class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);         // 각 알파벳을 숫자로 치환
        }
        
        String result = sb.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char c : result.toCharArray()) {       // 각 숫자들을 합해서 result를 갱신, k만큼 반복
                sum += c - '0';
            }
            
            result = String.valueOf(sum);
        }
        
        return Integer.parseInt(result);
    }
}

'''
Runtime: 1 ms, faster than 87.17% of Java online submissions for Sum of Digits of String After Convert.
Memory Usage: 37.2 MB, less than 90.87% of Java online submissions for Sum of Digits of String After Convert.
'''
