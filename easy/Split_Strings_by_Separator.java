/*
2788.
Split Strings by Separator
https://leetcode.com/problems/split-strings-by-separator/
*/

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            for (String w : word.split("\\" + separator)) {
                if (w.isBlank()) {
                    continue;
                }

                answer.add(w);
            }
        }

        return answer;
    }
}
