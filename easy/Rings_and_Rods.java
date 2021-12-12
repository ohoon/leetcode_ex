/*
2103.
Rings and Rods
https://leetcode.com/problems/rings-and-rods/
*/

class Solution {
    public int countPoints(String rings) {
        int answer = 0;
        int[][] rods = new int[10][3];      // 각 rod별로 ring의 개수를 색 별로 구한 배열
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int label = rings.charAt(i+1) - '0';
            switch (color) {                // 색 별로 개수를 셂
                case 'R':
                    rods[label][0]++;
                    break;
                case 'G':
                    rods[label][1]++;
                    break;
                case 'B':
                    rods[label][2]++;
                    break;
            }
        }

        for (int[] rod : rods) {
            if (rod[0] > 0 && rod[1] > 0 && rod[2] > 0) {       // 세 가지 색이 모두 있는 rod의 개수를 셂
                answer++;
            }
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Rings and Rods.
Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Rings and Rods.
*/
