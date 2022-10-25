/*
2390.
Removing Stars From a String
https://leetcode.com/problems/removing-stars-from-a-string/
*/

class Solution {
    public String removeStars(String s) {       // Stack
        Deque<Character> deq = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                deq.removeLast();
            } else {
                deq.addLast(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!deq.isEmpty()) {
            sb.append(deq.removeFirst());
        }
        
        return sb.toString();
    }
}

/*
Runtime: 150 ms, faster than 57.71% of Java online submissions for Removing Stars From a String.
Memory Usage: 101.8 MB, less than 10.98% of Java online submissions for Removing Stars From a String.
*/
