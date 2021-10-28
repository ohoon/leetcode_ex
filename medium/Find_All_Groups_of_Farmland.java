/*
1992.
Find All Groups of Farmland
https://leetcode.com/problems/find-all-groups-of-farmland/
*/

class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {      // farmland가 아니면 패스
                    continue;
                }
                
                if (i > 0 && land[i-1][j] == 1) {       // farmland의 제일 좌상단 땅이 아니면 패스
                    continue;
                }
                
                if (j > 0 && land[i][j-1] == 1) {
                    continue;
                }
                
                int[] group = new int[4];
                group[0] = i;                   // 시작 지점(좌상단 땅)
                group[1] = j;
                for (int k = i; k < land.length; k++) {     // 끝 지점(우하단 땅의 행 좌표)
                    if (k == land.length - 1 || land[k+1][j] == 0) {
                        group[2] = k;
                        break;
                    }
                }
                
                for (int l = j; l < land[0].length; l++) {  // 끝 지점(우하단 땅의 열 좌표)
                    if (l == land[0].length - 1 || land[i][l+1] == 0) {
                        group[3] = l;
                        break;
                    }
                }
                
                answer.add(group);
            }
        }
        
        return answer.stream()
            .toArray(int[][]::new);
    }
}

/*
Runtime: 7 ms, faster than 85.90% of Java online submissions for Find All Groups of Farmland.
Memory Usage: 50.2 MB, less than 78.57% of Java online submissions for Find All Groups of Farmland.
*/
