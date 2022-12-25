/*
2515.
Shortest Distance to Target String in a Circular Array
https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/
*/

class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        if (words[startIndex].equals(target)) {
            return 0;
        }
        
        for (int i = 1; i < n; i++) {
            if (words[(startIndex + i) % n].equals(target) || words[(startIndex + n - i) % n].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
