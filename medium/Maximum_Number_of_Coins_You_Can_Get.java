/*
1561.
Maximum Number of Coins You Can Get
https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
*/

class Solution {
    public int maxCoins(int[] piles) {
        Deque<Integer> deq = new LinkedList<>();
        Arrays.sort(piles);     // 
        for (int p : piles) {
            deq.addLast(p);
        }
        
        int answer = 0;
        while (!deq.isEmpty()) {
            deq.removeLast();       // Alice
            answer += deq.removeLast();     // Me
            deq.removeFirst();      // Bob
        }
        
        return answer;
    }
}

/*
Runtime: 59 ms, faster than 8.18% of Java online submissions for Maximum Number of Coins You Can Get.
Memory Usage: 76.1 MB, less than 23.25% of Java online submissions for Maximum Number of Coins You Can Get.
*/
