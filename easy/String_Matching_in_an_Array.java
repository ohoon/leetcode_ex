/*
1408.
String Matching in an Array
https://leetcode.com/problems/string-matching-in-an-array/
*/

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());          // 길이가 긴 순으로 정렬
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (words[j].contains(words[i])) {                          // contains을 사용
                    answer.add(words[i]);
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 85.45% of Java online submissions for String Matching in an Array.
Memory Usage: 38.9 MB, less than 69.11% of Java online submissions for String Matching in an Array.
*/
