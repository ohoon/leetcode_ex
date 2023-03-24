/*
443.
String Compression
https://leetcode.com/problems/string-compression/
*/

class Solution {
    public int compress(char[] chars) {     // two pointer
        int n = chars.length;
        int curA = 0, curB = 0;
        if (n == 1) {
            return 1;
        }

        while(curB < n){
            char ch = chars[curB];
            int count = 1;
            while(curB < n-1 && chars[curB] == chars[curB+1]){
                count++;
                curB++;
            }

            curB++;
            chars[curA++] = ch;
            if (count == 1) {
                continue;
            }

            String countStr = String.valueOf(count);
            for (int i = 0; i < countStr.length(); i++){
                chars[curA++] = countStr.charAt(i);
            }
        }

        return curA;
    }
}
