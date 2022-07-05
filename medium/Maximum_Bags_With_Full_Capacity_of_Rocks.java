/*
2279.
Maximum Bags With Full Capacity of Rocks
https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
*/

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {      // greedy
        for (int i = 0; i < capacity.length; i++) {     // capacity에서 현재 가방에 들어있는 rock개수를 빼서 더 들어갈 수 있는 rock의 개수를 나타냄
            capacity[i] -= rocks[i];
        }
        
        Arrays.sort(capacity);      // 가장 적은 rock을 사용해서 가방을 채울 수 있는 것을 우선
        int answer = 0;
        for (int c : capacity) {
            if (c > additionalRocks) {      // 돌이 부족해지면 종료
                break;
            }
            
            additionalRocks -= c;
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 25 ms, faster than 43.56% of Java online submissions for Maximum Bags With Full Capacity of Rocks.
Memory Usage: 83.6 MB, less than 84.79% of Java online submissions for Maximum Bags With Full Capacity of Rocks.
*/
