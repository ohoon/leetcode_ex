/*
1720.
Decode XORed Array
https://leetcode.com/problems/decode-xored-array/
*/

class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] answer = new int[encoded.length + 1];
        answer[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            answer[i+1] = answer[i] ^ encoded[i];       // XOR연산
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Decode XORed Array.
Memory Usage: 39.7 MB, less than 80.56% of Java online submissions for Decode XORed Array.
*/
