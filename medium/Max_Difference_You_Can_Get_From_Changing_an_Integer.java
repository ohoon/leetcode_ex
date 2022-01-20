/*
1432.
Max Difference You Can Get From Changing an Integer
https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
*/

class Solution {
    public int maxDiff(int num) {
        String first = String.valueOf(num);     // 문자열로 변환
        String second = String.valueOf(num);
        for (int i = 0; i < first.length(); i++) {      // 왼쪽 자리부터 탐색하여 나온 9가 아닌 첫번째 수를 9로 replace
            if (first.charAt(i) != '9') {
                first = first.replace(first.substring(i, i+1), "9");
                break;
            }
        }
        
        if (second.charAt(0) != '1') {      // 가장 왼쪽 자리수가 1이 아닌 경우, 해당 자리에 있는 수를 1로 replace
            second = second.replace(second.substring(0, 1), "1");
        } else {                            // 1...인 경우
            for (int i = 1; i < second.length(); i++) {
                if (second.charAt(i) > '1') {       // 2 이상의 수를 발견하면 그 숫자를 0으로 replace
                    second = second.replace(second.substring(i, i+1), "0");
                    break;
                }
            }
        }

        return Integer.parseInt(first) - Integer.parseInt(second);
    }
}

/*
Runtime: 1 ms, faster than 97.92% of Java online submissions for Max Difference You Can Get From Changing an Integer.
Memory Usage: 37.8 MB, less than 33.33% of Java online submissions for Max Difference You Can Get From Changing an Integer.
*/
