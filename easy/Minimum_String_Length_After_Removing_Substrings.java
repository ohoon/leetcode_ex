/*
2696.
Minimum String Length After Removing Substrings
https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
*/

class Solution {
    public int minLength(String s) {
        Deque<Character> deq = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (!deq.isEmpty() && ((deq.peekLast() == 'A' && ch == 'B') || (deq.peekLast() == 'C' && ch == 'D'))) {
                deq.removeLast();
                continue;
            }

            deq.addLast(ch);
        }

        return deq.size();
    }
}
