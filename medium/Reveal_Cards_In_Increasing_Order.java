/*
950.
Reveal Cards In Increasing Order
https://leetcode.com/problems/reveal-cards-in-increasing-order/
*/

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] answer = new int[deck.length];
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {         // 인덱스를 이용해서 간접적으로 접근
            deq.addLast(i);
        }
        
        Arrays.sort(deck);
        for (int card : deck) {
            answer[deq.removeFirst()] = card;           // reveal
            if (deq.isEmpty()) {
                break;
            }
            
            deq.addLast(deq.removeFirst());             // move bottom
        }
        
        return answer;
    }
}

/*
Runtime: 9 ms, faster than 20.21% of Java online submissions for Reveal Cards In Increasing Order.
Memory Usage: 44.5 MB, less than 28.40% of Java online submissions for Reveal Cards In Increasing Order.
*/

/*
여담

인덱스로 간접적 접근을 할 생각을 못해서 어떻게 풀어야 할지 고민을 많이 했다.
시뮬레이션하는 문제라고 생각은 했지만 원소를 직접 움직여가면서 하는 것은 비용이 너무 크기 때문에
인덱스만 움직여가면서 answer을 채워가는게 훨씬 비용이 저렴하다.

*/
