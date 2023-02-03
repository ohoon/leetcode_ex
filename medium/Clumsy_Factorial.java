/*
1006.
Clumsy Factorial
https://leetcode.com/problems/clumsy-factorial/
*/

class Solution {
    public int clumsy(int n) {
        List<Integer> list = new ArrayList<>();
        char[] operation = {'*', '/', '+', '-'};
        int result = n, extra = 0, index = 0;
        while (--n > 0) {
            char op = operation[index++ % 4];
            switch (op) {
                case '*':
                    result *= n;
                    break;
                case '/':
                    result /= n;
                    break;
                case '+':
                    extra += n;
                    break;
                case '-':
                    list.add(result);
                    result = n;
                    break;
            }
        }

        list.add(result);
        int answer = list.get(0) + extra;
        for (int i = 1; i < list.size(); i++) {
            answer -= list.get(i);
        }

        return answer;
    }
}
