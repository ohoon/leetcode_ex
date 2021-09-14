/*
1925.
Count Square Sum Triples
https://leetcode.com/problems/count-square-sum-triples/
*/

class Solution {
    public int countTriples(int n) {
        int answer = 0;
        for (int c = 1; c <= n; c++) {      // 1 ~ n까지 탐색
            int a = 1, b = c - 1;           // c미만의 범위 중 최소값과 최대값에 a와 b 포인터를 두고 값을 비교해 점차 줄여나가는 식으로 전개
            while (a < b) {
                int result = a*a + b*b - c*c;
                if (result < 0) {           // a*a + b*b가 c*c보다 작을 경우 a를 늘려서 result 값을 높임
                    a++;
                    continue;
                }
                
                if (result > 0) {           // a*a + b*b가 c*c보다 클 경우 b를 줄여서 result 값을 낮춤
                    b--;
                    continue;
                }
                
                answer += 2;                // 조건이 성립하는 경우 answer에 2를 추가 (쌍을 이루므로)
                b--;                        // 다른 해답이 있을 수도 있으니 b를 줄여서 재탐색
            }
        }
        
        return answer;
    }
}

/*
Runtime: 5 ms, faster than 91.08% of Java online submissions for Count Square Sum Triples.
Memory Usage: 37.9 MB, less than 30.43% of Java online submissions for Count Square Sum Triples.
*/
