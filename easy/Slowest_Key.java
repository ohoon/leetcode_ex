/*
1629.
Slowest Key
https://leetcode.com/problems/slowest-key/
*/

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];              // 최대 지속 시간
        char answer = keysPressed.charAt(0);    // 최대 지속 입력된 키 값
        for (int i = 1; i < keysPressed.length(); i++) {
            int dur = releaseTimes[i] - releaseTimes[i-1];      // 지속 시간
            if (dur > max || (dur == max && keysPressed.charAt(i) > answer)) {      // 지속 시간이 max와 같으면 키 값의 사전적 순서로 판단
                max = dur;
                answer = keysPressed.charAt(i);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 65.04% of Java online submissions for Slowest Key.
Memory Usage: 39.2 MB, less than 18.83% of Java online submissions for Slowest Key.
*/
