/*
2433.
Find The Original Array of Prefix Xor
https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
*/

class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] answer = new int[n];
        answer[0] = pref[0];
        for (int i = 1; i < n; i++) {       // xor을 2번하면 원래 숫자가 나옴
            answer[i] = pref[i-1] ^ pref[i];
        }
        
        return answer;
    }
}

/*
Runtime: 6 ms, faster than 36.72% of Java online submissions for Find The Original Array of Prefix Xor.
Memory Usage: 114.1 MB, less than 10.37% of Java online submissions for Find The Original Array of Prefix Xor.
*/
