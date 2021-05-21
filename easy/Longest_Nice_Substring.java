/*
1763.
Longest Nice Substring
https://leetcode.com/problems/longest-nice-substring/
*/

class Solution {
    public String longestNiceSubstring(String s) {
        int maxLength = 0;
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                String sub = s.substring(i, j+1);
                Set<Character> set = sub.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
                boolean isNice = true;
                for (char c : set) {
                    if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))) {
                        isNice = false;
                        break;
                    }

                    if (Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c))) {
                        isNice = false;
                        break;
                    }
                }

                if (isNice && sub.length() > maxLength) {
                    maxLength = sub.length();
                    answer = sub;
                    break;
                }
            }
        }

        return answer;
    }
}

/*
Runtime: 119 ms, faster than 5.01% of Java online submissions for Longest Nice Substring.
Memory Usage: 39.3 MB, less than 39.57% of Java online submissions for Longest Nice Substring.
*/

/*
여담

풀리기는 하지만 속도가 잘 나오지 않는게 많이 아쉽다.
비트마스킹이나 분할정복 방법이 있는 것이 아마 더 효율적인 방법이 되지 않을까 싶다.

*/
