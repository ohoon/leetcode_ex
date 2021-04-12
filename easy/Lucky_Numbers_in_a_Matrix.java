/*
1380.
Lucky Numbers in a Matrix
https://leetcode.com/problems/lucky-numbers-in-a-matrix/
*/

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        for (int[] rows : matrix) {
            List<Integer> list = Arrays.stream(rows).boxed().collect(Collectors.toList());      // list화
            int elem = Collections.min(list);       // 최솟값
            int col = list.indexOf(elem);           // 최솟값의 인덱스
            boolean isLucky = true;
            for (int i = 0; i < matrix.length; i++) {       // 최솟값이 있는 열을 탐색
                if (matrix[i][col] > elem) {                // 최댓값이 아닌 경우 isLucky = false
                    isLucky = false;
                    break;
                }
            }
            
            if (isLucky) {
                answer.add(elem);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 8 ms, faster than 8.25% of Java online submissions for Lucky Numbers in a Matrix.
Memory Usage: 39.3 MB, less than 82.04% of Java online submissions for Lucky Numbers in a Matrix.
*/

/*
여담

속도가 좀 느리게 나오는데 다른 솔루션을 보면 풀이하는 로직은 같지만
최소값, 최대값 탐색을 for문으로 돌려 list로 맵핑하는 과정을 안해서 빠른듯하다.

*/
