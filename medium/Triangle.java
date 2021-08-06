/*
120.
Triangle
https://leetcode.com/problems/triangle/
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {                 // dynamic programming
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int current = triangle.get(i).get(j);
                int prev;
                if (j == 0) {
                    prev = triangle.get(i-1).get(j);
                    triangle.get(i).set(j, current + prev);
                } else if (j == triangle.get(i).size() - 1) {
                    prev = triangle.get(i-1).get(j-1);
                    triangle.get(i).set(j, current + prev);
                } else {
                    prev = Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1));
                    triangle.get(i).set(j, current + prev);
                }
            }
        }
        
        return triangle.get(triangle.size() - 1)
            .stream()
            .mapToInt(v -> v)
            .min()
            .orElse(-1);
    }
}

/*
Runtime: 7 ms, faster than 12.70% of Java online submissions for Triangle.
Memory Usage: 39 MB, less than 58.02% of Java online submissions for Triangle.
*/

/*
다른 사람의 풀이

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}

dp로 풀이하는 방향 자체는 맞았지만 top에서 bottom으로 탐색이 아니라 bottom에서 top으로 탐색을 해야 효율적인 코드를 짤 수 있었던 문제였다.
밑에서 위로 값을 더해가면 if로 자식 값이 있는지 체크할 일도 없고 제일 위의 값이 정답이므로 최솟값을 추려낼 이유도 없어지게 된다.
좀 더 세심하게 생각했으면 어땠을까 하는 아쉬움이 남는다.

*/
