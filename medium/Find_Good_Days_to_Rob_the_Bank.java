/*
2100.
Find Good Days to Rob the Bank
https://leetcode.com/problems/find-good-days-to-rob-the-bank/
*/

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {      // prefix
        int n = security.length;
        int[] nonInc = new int[n];      // 0 ~ i-1까지 연속적으로 non-increase인 원소가 나온 횟수를 담는 배열
        int[] nonDec = new int[n];      // i+1 ~ n-1까지 연속적으로 non-decrease인 원소가 나온 횟수를 담는 배열
        for (int i = 1; i < n; i++) {       // nonInc 배열 값을 계산
            if (security[i] > security[i-1]) {
                nonInc[i] = 0;
                continue;
            }
            
            nonInc[i] = nonInc[i-1] + 1;
        }
        
        for (int i = n-2; i >= 0; i--) {        // nonDec 배열 값을 계산
            if (security[i] > security[i+1]) {
                nonDec[i] = 0;
                continue;
            }
            
            nonDec[i] = nonDec[i+1] + 1;
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = time; i < n-time; i++) {
            if (nonInc[i] < time || nonDec[i] < time) {     // i를 기준으로 왼쪽에는 non-increase 값이, 오른쪽에는 non-decrease 값이 time 개 이상이어야 함
                continue;
            }
            
            answer.add(i);
        }
        
        return answer;
    }
}

/*
Runtime: 8 ms, faster than 82.93% of Java online submissions for Find Good Days to Rob the Bank.
Memory Usage: 62.2 MB, less than 80.00% of Java online submissions for Find Good Days to Rob the Bank.
*/
