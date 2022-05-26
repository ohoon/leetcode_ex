/*
1423.
Maximum Points You Can Obtain from Cards
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {      // sliding window
        int answer = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {       // 0 ~ k-1 번째 요소들의 합을 구함 (base)
            answer += cardPoints[i];
        }
        
        if (n == k) {
            return answer;
        }
        
        int point = answer;
        for (int i = 0; i < k; i++) {       // k-1번째부터 하나씩 제거하고 제일 끝의 요소를 차례대로 추가
            point -= cardPoints[k-i-1];
            point += cardPoints[n-i-1];
            answer = Math.max(answer, point);       // answer 갱신
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 52.58% of Java online submissions for Maximum Points You Can Obtain from Cards.
Memory Usage: 65.3 MB, less than 55.26% of Java online submissions for Maximum Points You Can Obtain from Cards.
*/
