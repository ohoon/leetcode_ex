/*
57.
Insert Interval
https://leetcode.com/problems/insert-interval/
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {                // intervals이 비어있으면 newInterval 반환
            return new int[][]{newInterval};
        }
        
        List<int[]> answer = new ArrayList<>();
        int i;
        int left = -1, right = -1;
        boolean mergeStart = false, mergeEnd = false;
        for (i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (!mergeStart) {                          // newInterval에 병합중이 아닐 경우
                if (interval[1] < newInterval[0]) {     // interval이 newInterval보다 앞일 경우
                    answer.add(interval);
                    continue;
                }
                
                if (interval[0] > newInterval[1]) {     // interval이 newInterval보다 뒤일 경우
                    mergeEnd = true;
                    answer.add(newInterval);
                    insertRest(answer, intervals, i);
                    break;
                }
                                                        // interval과 newInterval이 겹칠 경우
                mergeStart = true;
                left = Math.min(interval[0], newInterval[0]);
                right = Math.max(interval[1], newInterval[1]);
                continue;
            }
            
            if (mergeStart) {                           // 병합중인 경우
                if (interval[0] > newInterval[1]) {     // interval이 newInterval보다 뒤일 경우 병합이 종료되고 나머지 요소들을 answer에 삽입하고 break
                    mergeStart = false;
                    mergeEnd = true;
                    answer.add(new int[]{left, right});
                    insertRest(answer, intervals, i);
                    break;
                }
                
                right = Math.max(interval[1], newInterval[1]);      // 아직 겹친 상태라면 right 갱신
            }
        }
        
        if (mergeStart) {                           // 아직 병합이 종료되지 않은 상태라면 강제로 병합을 종료하고 answer에 삽입
            answer.add(new int[]{left, right});
        } else if (!mergeEnd) {                     // 아예 병합이 시작되지 않은 경우 newInterval을 삽입
            answer.add(newInterval);
        }
        
        return answer.toArray(new int[answer.size()][2]);
    }
    
    private void insertRest(List<int[]> list, int[][] arr, int index) {
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
        }
    }
}

/*
Runtime: 1 ms, faster than 98.70% of Java online submissions for Insert Interval.
Memory Usage: 41.8 MB, less than 21.49% of Java online submissions for Insert Interval.
*/

/*
다른 사람의 풀이

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> result = new ArrayList<>();
        
        // Iterate through all slots
        for(int[] slot : intervals)
        {
            
            // if newInterval before slot insert newInterval & update slot as new interval
            if(newInterval[1] < slot[0])
            {
                result.add(newInterval);
                newInterval = slot;
            } 
            
            // if slot is lesser than new Interval insert slot
            else if(slot[1] < newInterval[0])
            {
                result.add(slot);
            } 
            
            // if above conditions fail its an overlap since possibility of new interval existing in left & right of slot is checked
            // update lowest of start & highest of end & not insert
            else {
                newInterval[0] = Math.min(newInterval[0],slot[0]);
                newInterval[1] = Math.max(newInterval[1],slot[1]);
            }
        }
        
        // insert the last newInterval
        result.add(newInterval);
        
        // convert to int[][] array
        return result.toArray(new int[result.size()][]);
    }
}

내 코드가 너무 복잡해서 마음에 들지 않았는데, 위의 풀이처럼 newInterval을 갱신하면서 전개하면 코드가 훨씬 깔끔해지는 것을 볼 수 있다..
newInterval을 탐색할 때 비교하는 용으로만 사용한다는 고정관념에 박혀서 이러한 점을 생각하지 못했다.
코드를 정독하고 이해해서 최대한 유연하게 문제를 풀이해야겠다.

*/
