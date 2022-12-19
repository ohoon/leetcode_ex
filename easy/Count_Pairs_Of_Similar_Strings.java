/*
2506.
Count Pairs Of Similar Strings
https://leetcode.com/problems/count-pairs-of-similar-strings/
*/

class Solution {
    public int similarPairs(String[] words) {
        int n = words.length;
        List<Set<Character>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (char ch : words[i].toCharArray()) {
                set.add(ch);
            }

            list.add(set);
        }

        int answer = 0;
        for (int i = 0; i < n-1; i++) {
            int sizeA = list.get(i).size();
            for (int j = i+1; j < n; j++) {
                int sizeB = list.get(j).size();
                if (sizeA != sizeB) {
                    continue;
                }

                Set<Character> newSet = new HashSet<>(list.get(i));
                newSet.retainAll(list.get(j));
                if (sizeA != newSet.size()) {
                    continue;
                }

                answer++;
            }
        }

        return answer;
    }
}
