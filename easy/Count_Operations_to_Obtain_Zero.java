/*
2169.
Count Operations to Obtain Zero
https://leetcode.com/problems/count-operations-to-obtain-zero/
*/

class Solution {
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {       // 한 숫자가 0에 달하면 조건 성립
            return 0;
        }
        
        if (num1 > num2) {
            if (num1 % num2 == 0) {         // 나누어떨어지면 몫만큼 연산이 이루어짐
                return num1 / num2;
            }
            
            return num1 / num2 + countOperations(num1 % num2, num2);        // 몫만큼 연산이 이루어진 후, 나머지 값으로 다시 순회하여 탐색
        }
        
        if (num1 < num2) {
            if (num2 % num1 == 0) {
                return num2 / num1;
            }
            
            return num2 / num1 + countOperations(num1, num2 % num1);
        }
        
        return 1;       // num1 == num2인 경우, 한 번의 연산이 필요
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Operations to Obtain Zero.
Memory Usage: 39.3 MB, less than 66.67% of Java online submissions for Count Operations to Obtain Zero.
*/
