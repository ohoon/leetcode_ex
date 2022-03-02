/*
791.
Custom Sort String
https://leetcode.com/problems/custom-sort-string/
*/

class Solution {
    public String customSortString(String order, String s) {
        int[] rank = new int[26];
        int n = order.length();
        for (int i = 0; i < n; i++) {       // 알파벳 별로 우선순위 저장
            rank[order.charAt(i) - 'a'] = n - i;
        }
        
        int m = s.length();
        Character[] chrs = new Character[m];
        for (int i = 0; i < m; i++) {       // custom sort를 위해 char[] -> Character[]
            chrs[i] = s.charAt(i);
        }
        
        Arrays.sort(chrs, (c1, c2) -> rank[c2 - 'a'] - rank[c1 - 'a']);     // rank 배열을 참고해서 정렬
        StringBuilder sb = new StringBuilder();
        for (Character c : chrs) {      // 정렬된 문자들을 StringBuilder에 삽입하여 문자열로 재출력
            sb.append(c);
        }
        
        return sb.toString();
    }
}

/*
Runtime: 4 ms, faster than 32.90% of Java online submissions for Custom Sort String.
Memory Usage: 42.7 MB, less than 9.05% of Java online submissions for Custom Sort String.
*/
