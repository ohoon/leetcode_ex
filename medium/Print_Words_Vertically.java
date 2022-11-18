/*
1324.
Print Words Vertically
https://leetcode.com/problems/print-words-vertically/
*/

class Solution {
    public List<String> printVertically(String s) {
        List<String> answer = new ArrayList<>();
        String[] split = s.split(" ");
        int max = 0;        // 가장 긴 단어의 길이
        for (String str : split) {
            max = Math.max(max, str.length());
        }

        for (int i = 0; i < max; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < split.length; j++) {
                sb.append(i < split[j].length() ? split[j].charAt(i) : " ");        // 0부터 max까지 단어의 한 알파벳씩 가져옴
            }

            for (int j = sb.length() - 1; j >= 0; j--) {        // '    A    '처럼 마지막 알파벳 뒤의 공백을 제거하기 위함
                if (sb.charAt(j) >= 'A') {
                    sb.delete(j+1, sb.length());
                    break;
                }
            }

            answer.add(sb.toString());
        }

        return answer;
    }
}
