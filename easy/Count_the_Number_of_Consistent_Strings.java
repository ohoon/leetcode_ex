/*
1684.
Count the Number of Consistent Strings
https://leetcode.com/problems/count-the-number-of-consistent-strings/
*/

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();       // allowed에 포함된 알파벳을 담기위한 set
        int answer = 0;
        for (int i = 0; i < allowed.length(); i++) {    // set에 allowed 알파벳 저장
            set.add(allowed.charAt(i));
        }

        for (String word : words) {
            boolean isGood = true;
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {        // set에 없는 알파벳이 나오면 break
                    isGood = false;
                    break;
                }
            }

            if (isGood) {                                   // 모든 알파벳이 set에 포함되면 answer 증가
                answer++;
            }
        }

        return answer;
    }
}

/*
Runtime: 9 ms, faster than 76.35% of Java online submissions for Count the Number of Consistent Strings.
Memory Usage: 39.6 MB, less than 63.29% of Java online submissions for Count the Number of Consistent Strings.
*/
