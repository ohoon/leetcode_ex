/*
1323.
Maximum 69 Number
https://leetcode.com/problems/maximum-69-number/
*/

class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);             // num을 stringify하여 builder에 삽입
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6') {      // 가장 큰 자리부터 시작하여 6을 만나면 9로 바꾸고 반환
                sb.setCharAt(i, '9');
                break;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum 69 Number.
Memory Usage: 35.7 MB, less than 80.08% of Java online submissions for Maximum 69 Number.
*/
