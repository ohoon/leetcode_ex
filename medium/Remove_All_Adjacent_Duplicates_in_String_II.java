/*
1209.
Remove All Adjacent Duplicates in String II
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
*/

class Solution {
    class Letter {      // 알파벳과 빈도수를 묶어서 표현하기 위해서 클래스를 만듦
        char ch;
        int freq;
        
        public Letter(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Deque<Letter> deq = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!deq.isEmpty() && deq.peekLast().ch == c) {     // 알파벳이 연속해서 나오는 경우
                if (++deq.peekLast().freq == k) {               // 빈도수를 높여주고, k번 반복됐다면 deque에서 제거
                    deq.removeLast();
                }
            } else {
                deq.addLast(new Letter(c, 1));                  // 연속해서 나오지 않은 경우는 빈도수를 1로 설정하여 deque에 삽입
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!deq.isEmpty()) {            // deque 앞부터 차례대로 알파벳을 빈도수에 따라 stringbuilder에 삽입해줌
            Letter p = deq.removeFirst();
            sb.append(String.valueOf(p.ch).repeat(p.freq));
        }
        
        return sb.toString();
    }
}

/*
Runtime: 28 ms, faster than 79.05% of Java online submissions for Remove All Adjacent Duplicates in String II.
Memory Usage: 52 MB, less than 36.53% of Java online submissions for Remove All Adjacent Duplicates in String II.
*/
