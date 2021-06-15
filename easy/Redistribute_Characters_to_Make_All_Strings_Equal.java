/*
1897.
Redistribute Characters to Make All Strings Equal
https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
*/

class Solution {
    public boolean makeEqual(String[] words) {
        int[] arr = new int[26];                // 알파벳 개수가 입력될 배열
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {      // 해당하는 알파벳 버켓에 개수 누적
                arr[w.charAt(i) - 'a']++;
            }
        }
        
        for (int x : arr) {
            if (x % words.length > 0) {                 // 해당 알파벳을 골고루 나눠줄 수 없으면 false
                return false;
            }
        }
        
        return true;
    }
}

/*
Runtime: 3 ms, faster than 88.33% of Java online submissions for Redistribute Characters to Make All Strings Equal.
Memory Usage: 38.5 MB, less than 92.40% of Java online submissions for Redistribute Characters to Make All Strings Equal.
*/
