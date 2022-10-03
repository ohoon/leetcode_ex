/*
2423.
Remove Letter To Equalize Frequency
https://leetcode.com/problems/remove-letter-to-equalize-frequency/
*/

class Solution {
    private boolean isEqualized(int[] freq) {
        int prev = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            
            if (prev == -1) {
                prev = freq[i];
                continue;
            }
            
            if (prev != freq[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        boolean isRemove = false;
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            
            freq[i]--;
            if (isEqualized(freq)) {
                return true;
            }
            
            freq[i]++;
        }
        
        return false;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Remove Letter To Equalize Frequency.
Memory Usage: 42 MB, less than 100.00% of Java online submissions for Remove Letter To Equalize Frequency.
*/
