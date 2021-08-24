/*
318.
Maximum Product of Word Lengths
https://leetcode.com/problems/maximum-product-of-word-lengths/
*/

class Solution {
    public int maxProduct(String[] words) {
        int answer = 0;
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {        // word별로 어떤 알파벳을 쓰는지 알기 위해서 bit로 매핑
            bits[i] = wordToInteger(words[i]);
        }
        
        for (int i = 0; i < bits.length - 1; i++) {
            for (int j = i + 1; j < bits.length; j++) {
                if ((bits[i] & bits[j]) > 0) {      // 겹치는 bit가 있을 경우 (= 중복되는 알파벳이 있는 경우) 패스
                    continue;
                }
                
                answer = Math.max(answer, words[i].length() * words[j].length());
            }
        }
        
        return answer;
    }
    
    private int wordToInteger(String word) {        // 각 알파벳을 bit로 매핑한 결과를 반환하는 함수
        int result = 0;
        for (char c : word.toCharArray()) {
            result |= (int) Math.pow(2, c - 'a');   // 1 << (c - 'a')가 더 효율적
        }
        
        return result;
    }
}

/*
Runtime: 14 ms, faster than 48.88% of Java online submissions for Maximum Product of Word Lengths.
Memory Usage: 39.4 MB, less than 33.58% of Java online submissions for Maximum Product of Word Lengths.
*/
