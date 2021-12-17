/*
648.
Replace Words
https://leetcode.com/problems/replace-words/
*/

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, (d1, d2) -> d1.length() - d2.length());        // root 길이가 짧은 순서대로 정렬
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < dictionary.size(); j++) {               // word 별로 어떤 root로 시작하는지 탐색
                if (split[i].startsWith(dictionary.get(j))) {           // 해당 root로 word가 시작하면 word를 root로 대치
                    split[i] = dictionary.get(j);
                    break;
                }
            }
        }

        return String.join(" ", split);             // 대치가 모두 끝난 split 배열을 join으로 합쳐서 반환
    }
}

/*
Runtime: 26 ms, faster than 39.62% of Java online submissions for Replace Words.
Memory Usage: 42.8 MB, less than 95.01% of Java online submissions for Replace Words.
*/

/*
여담

아직 Trie에 대해서 이해가 부족해서 Trie를 이용해서 풀지 못했지만
다른 사람 풀이를 보면서 trie를 어떻게 사용해야할지 감을 잡았다.
Prefix에 관한 문제가 나올 때 Trie를 이용하면 효과적으로 문제를 풀이할 수 있을 듯하다.

 */
