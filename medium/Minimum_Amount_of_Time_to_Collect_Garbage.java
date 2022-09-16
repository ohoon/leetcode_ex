/*
2391.
Minimum Amount of Time to Collect Garbage
https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
*/

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {          // prefix
        int answer = 0, n = garbage.length;
        int[] lastIndex = new int[]{-1, -1, -1};            // 'M' 'P' 'G'가 가장 나중에 나온 인덱스를 기록하는 배열
        for (int i = n-1; i >= 0; i--) {
            if (lastIndex[0] == -1 && garbage[i].indexOf("M") > -1) {
                lastIndex[0] = i;
            }
            
            if (lastIndex[1] == -1 && garbage[i].indexOf("P") > -1) {
                lastIndex[1] = i;
            }
            
            if (lastIndex[2] == -1 && garbage[i].indexOf("G") > -1) {
                lastIndex[2] = i;
            }
            
            answer += garbage[i].length();
        }
        
        int[] sum = new int[n];
        for (int i = 1; i < n; i++) {               // travel의 값을 누적
            sum[i] += sum[i-1] + travel[i-1];
        }
        
        for (int i = 0; i < 3; i++) {
            if (lastIndex[i] > -1) {
                answer += sum[lastIndex[i]];        // 각 쓰레기 종류 별로 마지막에 나온 인덱스까지만 travel의 값을 더함
            }
        }
        
        return answer;
    }
}

/*
Runtime: 12 ms, faster than 96.85% of Java online submissions for Minimum Amount of Time to Collect Garbage.
Memory Usage: 88.5 MB, less than 85.46% of Java online submissions for Minimum Amount of Time to Collect Garbage.
*/
