/*
2129.
Capitalize the Title
https://leetcode.com/problems/capitalize-the-title/
*/

class Solution {
    private String capitalize(String text) {        // capitalize하는 메서드
        if (text.length() <= 2) {           // 길이가 1~2이면 소문자로
            return text.toLowerCase();
        }
        
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();        // 길이가 2를 초과하면 첫 문자만 대문자로 나머지는 소문자로
    }
    public String capitalizeTitle(String title) {
        String[] split = title.split(" ");          // 공백을 기준으로 split
        for (int i = 0; i < split.length; i++) {
            split[i] = capitalize(split[i]);
        }
        
        return String.join(" ", split);             // capitalize한 split을 join하여 반환
    }
}

/*
Runtime: 3 ms, faster than 20.00% of Java online submissions for Capitalize the Title.
Memory Usage: 38.9 MB, less than 20.00% of Java online submissions for Capitalize the Title.
*/
