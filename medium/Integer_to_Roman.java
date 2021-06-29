/*
12.
Integer to Roman
https://leetcode.com/problems/integer-to-roman/
*/

class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
            } else if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else if (num >= 500) {
                sb.append("D");
                num -= 500;
            } else if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else if (num >= 100) {
                sb.append("C");
                num -= 100;
            } else if (num >= 90) {
                sb.append("XC");
                num -= 90;
            } else if (num >= 50) {
                sb.append("L");
                num -= 50;
            } else if (num >= 40) {
                sb.append("XL");
                num -= 40;
            } else if (num >= 10) {
                sb.append("X");
                num -= 10;
            } else if (num >= 9) {
                sb.append("IX");
                num -= 9;
            } else if (num >= 5) {
                sb.append("V");
                num -= 5;
            } else if (num >= 4) {
                sb.append("IV");
                num -= 4;
            } else {
                sb.append("I");
                num -= 1;
            }
        }
        
        return sb.toString();
    }
}

/*
Runtime: 3 ms, faster than 100.00% of Java online submissions for Integer to Roman.
Memory Usage: 37.9 MB, less than 98.12% of Java online submissions for Integer to Roman.
*/

/*
다른 사람의 풀이

class Solution {
    final static int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    final static String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int N) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; N > 0; i++)
            while (N >= val[i]) {
                ans.append(rom[i]);
                N -= val[i];
            }
        return ans.toString();
    }
}

if-else로 도배를 해놓는 것이 마음에 안들었었는데, 배열을 2개 만들어서 매핑하는 식으로 바꾸면 훨씬 코드가 간결해짐을 알 수 있었다.
그리고 매 stage마다 조건식을 처음부터 끝까지 계속 불필요하게 반복해야하는 문제점도 사라진다.
배열이라는 자료구조의 장점을 살려 코딩하도록 해야겠다.

*/
