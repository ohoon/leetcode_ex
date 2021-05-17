/*
1742.
Maximum Number of Balls in a Box
https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
*/

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] boxes = new int[50];
        int answer = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            answer = Math.max(answer, ++boxes[sumOfDigits(i)]);         // 최대 box값 갱신
        }
        
        return answer;
    }
    
    private int sumOfDigits(int num) {          // num의 각 자리 수를 합한 값을 반환하는 함수
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        
        return result;
    }
}

/*
Runtime: 21 ms, faster than 63.94% of Java online submissions for Maximum Number of Balls in a Box.
Memory Usage: 35.9 MB, less than 67.27% of Java online submissions for Maximum Number of Balls in a Box.
*/
