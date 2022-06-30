/*
646.
Maximum Length of Pair Chain
https://leetcode.com/problems/maximum-length-of-pair-chain/
*/

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (x, y) -> x[1] - y[1]);      // right를 기준으로 오름차순 정렬
        int answer = 0, prev = -1001;
        for (int[] p : pairs) {
            if (p[0] <= prev) {     // chain이 불가능하면 다음으로
                continue;
            }
            
            answer++;
            prev = p[1];
        }
        
        return answer;
    }
}

/*
Runtime: 14 ms, faster than 73.35% of Java online submissions for Maximum Length of Pair Chain.
Memory Usage: 54.1 MB, less than 44.69% of Java online submissions for Maximum Length of Pair Chain.
*/
