/*
2171.
Removing Minimum Number of Magic Beans
https://leetcode.com/problems/removing-minimum-number-of-magic-beans/
*/

class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);     // 오름차순 정렬
        long answer = Long.MAX_VALUE;
        long n = beans.length;
        long sum = Arrays.stream(beans).mapToLong(v -> v).sum();        // 전체 원소들의 합을 long 타입으로 계산하여 구함
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, sum - beans[i] * (n-i));          // (a, b, c)를 (a, a, a)로 바꾸기 위해서는 전체 원소를 0으로 만들고 a로 처음부터 끝까지 통일시키면 됨
        }                                                               // b의 경우에는 (0, b, b)로 만들어야 하기 때문에 2번째 원소부터 통일시킴
        
        return answer;
    }
}

/*
Runtime: 56 ms, faster than 18.94% of Java online submissions for Removing Minimum Number of Magic Beans.
Memory Usage: 111.8 MB, less than 28.13% of Java online submissions for Removing Minimum Number of Magic Beans.
*/
