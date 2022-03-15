/*
1894.
Find the Student that Will Replace the Chalk
https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/
*/

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;       // chalk들의 총 합 = 한 사이클에 필요한 chalk 개수
        for (int c : chalk) {
            sum += c;
        }
        
        k %= sum;           // k가 충분히 커서 의미없이 여러 사이클을 돌 경우를 생각하여 sum으로 나눈 나머지만 고려
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            
            k -= chalk[i];
        }
        
        return -1;
    }
}

/*
Runtime: 2 ms, faster than 84.74% of Java online submissions for Find the Student that Will Replace the Chalk.
Memory Usage: 79.5 MB, less than 58.95% of Java online submissions for Find the Student that Will Replace the Chalk.
*/
