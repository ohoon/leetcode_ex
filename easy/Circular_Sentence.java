/*
2490.
Circular Sentence
https://leetcode.com/problems/circular-sentence/
*/

class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].charAt(words[i].length()-1) != words[(i+1)%n].charAt(0)) {
                return false;
            }
        }

        return true;
    }
}
