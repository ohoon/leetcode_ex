/*
1592.
Rearrange Spaces Between Words
https://leetcode.com/problems/rearrange-spaces-between-words/
*/

class Solution {
    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();
        int spaces = 0;         // 공백 갯수
        int startIndex = 0;     // 단어 시작 인덱스
        boolean start = false;  // 단어 시작 여부
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            }
            
            if (!start && text.charAt(i) != ' ') {      // 단어 시작
                start = true;
                startIndex = i;
                continue;
            }
            
            if (start && text.charAt(i) == ' ') {       // 단어 끝
                start = false;
                words.add(text.substring(startIndex, i));       // 추출한 단어를 words에 저장
                continue;
            }
        }
        
        if (start) {            // 마지막 단어 처리
            words.add(text.substring(startIndex, text.length()));
        }
        
        if (words.size() == 1) {        // 단어가 하나 뿐이면 모든 공백을 단어 뒤에 붙여서 반환
            return words.get(0).concat(new String(new char[spaces]).replace('\0', ' '));
        }
        
        int avg = spaces / (words.size() - 1);      // 평균 공백 갯수
        String avgStr = new String(new char[avg]).replace('\0', ' ');       // 평균 공백 문자열
        int mod = spaces % (words.size() - 1);      // 나머지 공백 갯수
        String modStr = new String(new char[mod]).replace('\0', ' ');       // 나머지 공백 문자열
        
        return String.join(avgStr, words).concat(modStr);                   // 단어 사이는 평균 공백으로, 단어 끝은 나머지 공백으로 처리
    }
}

/*
Runtime: 1 ms, faster than 88.40% of Java online submissions for Rearrange Spaces Between Words.
Memory Usage: 37.3 MB, less than 68.07% of Java online submissions for Rearrange Spaces Between Words.
*/
