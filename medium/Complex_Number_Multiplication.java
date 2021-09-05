/*
537.
Complex Number Multiplication
https://leetcode.com/problems/complex-number-multiplication/
*/

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] split1 = num1.split("\\+");
        String[] split2 = num2.split("\\+");
        int real1 = Integer.parseInt(split1[0]);
        int real2 = Integer.parseInt(split2[0]);
        int imaginary1 = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1));
        int imaginary2 = Integer.parseInt(split2[1].substring(0, split2[1].length() - 1));
        return (real1 * real2 - imaginary1 * imaginary2) + "+" + (real1 * imaginary2 + real2 * imaginary1) + "i";
    }
}

/*
Runtime: 4 ms, faster than 75.86% of Java online submissions for Complex Number Multiplication.
Memory Usage: 37.4 MB, less than 54.17% of Java online submissions for Complex Number Multiplication.
*/

/*
여담

이게 왜 medium 문제인지도 모르겠고, 별다른 알고리즘을 사용하지 않아도 수학적으로 풀이할 수 있는 문제라서 허무했다.
그나마 머리를 써서 풀이해도 정규식 정도만 사용하는듯

*/
