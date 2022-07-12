/*
1024.
Video Stitching
https://leetcode.com/problems/video-stitching/
*/

class Solution {
    public int videoStitching(int[][] clips, int time) {        // greedy
        int answer = 0, cur = 0, max = 0;
        Arrays.sort(clips, (x, y) -> x[0] - y[0]);      // start지점을 기준으로 오름차순 정렬
        for (int[] c : clips) {
            if (c[0] > cur) {           // 범위를 벗어나 cur의 갱신이 필요한 경우
                if (max <= cur) {       // max가 갱신이 안되면 비디오를 이을 수 없으므로 반복문을 종료하고 -1 반환
                    break;
                }
                
                cur = max;
                answer++;
            }
            
            if (c[0] <= cur) {
                if (c[1] >= time) {     // time 목표치를 만족하면 answer+1 반환
                    return ++answer;
                }
                
                max = Math.max(max, c[1]);      // 고를 수 있는 clip 중에 가장 end 지점이 멀리 있는 clip을 선택
            }
        }
        
        return -1;
    }
}

/*
Runtime: 1 ms, faster than 89.09% of Java online submissions for Video Stitching.
Memory Usage: 41.3 MB, less than 77.85% of Java online submissions for Video Stitching.
*/
