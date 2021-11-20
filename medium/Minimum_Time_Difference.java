/*
539.
Minimum Time Difference
https://leetcode.com/problems/minimum-time-difference/
*/

class Solution {
    private Map<String, Integer> map = new HashMap<>();     // key가 format 문자열이고 value가 timescale인 맵 정의
    
    private int toTimeScale(String format) {                // format를 받아와서 해시맵 조회하여 timescale를 계산해서 반환하는 함수
        if (!map.containsKey(format)) {
            String[] t = format.split(":");
            map.put(format, Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]));
        }
        
        return map.get(format);
    }
    
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int temp = toTimeScale(timePoints.get(timePoints.size()-1)) - toTimeScale(timePoints.get(0));
        int answer = Math.min(temp, 1440 - temp);
        for (int i = 1; i < timePoints.size(); i++) {
            temp = toTimeScale(timePoints.get(i)) - toTimeScale(timePoints.get(i-1));
            int result = Math.min(temp, 1440 - temp);
            answer = Math.min(answer, result);
        }
        
        return answer;
    }
}

/*
Runtime: 13 ms, faster than 32.42% of Java online submissions for Minimum Time Difference.
Memory Usage: 38.6 MB, less than 93.69% of Java online submissions for Minimum Time Difference.
*/
