/*
406.
Queue Reconstruction by Height
https://leetcode.com/problems/queue-reconstruction-by-height/
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] answer = new int[n][2];
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);        // height 오름차순으로 정렬, height가 같은 경우엔 front 내림차순으로
        int[] front = new int[n];       // 해당 person의 키보다 같거나 큰 사람의 수를 나타내는 배열
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (people[j][1] == front[j]) {     // front 조건을 성립하면
                    answer[i] = people[j];
                    front[j]++;
                    break;
                }
                
                front[j]++;     // front 카운팅처리
            }
        }
        
        return answer;
    }
}

/*
Runtime: 26 ms, faster than 14.30% of Java online submissions for Queue Reconstruction by Height.
Memory Usage: 54.7 MB, less than 54.92% of Java online submissions for Queue Reconstruction by Height.
*/
