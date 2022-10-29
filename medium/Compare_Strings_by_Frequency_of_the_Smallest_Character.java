/*
1170.
Compare Strings by Frequency of the Smallest Character
https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
*/

class Solution {
    private int binarySearch(int[] arr, int target) {       // 이진탐색
        int L = 0, R = arr.length;
        while (L < R) {
            int m = (L+R) / 2;
            if (arr[m] <= target) {
                L = m+1;
            } else {
                R = m;
            }
        }
        
        return R;
    }
    
    private int strToFreq(String str) {             // 문자열 안 가장 작은 알파벳의 빈도를 계산하는 메서드
        int[] res = {str.charAt(0) - 'a', 1};
        for (int i = 1; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (res[0] < idx) {
                continue;
            }
            
            if (res[0] == idx) {
                res[1]++;
                continue;
            }
            
            res[0] = idx;
            res[1] = 1;
        }
        
        return res[1];
    }
    
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int m = queries.length, n = words.length;
        int[] freqs = new int[n];
        for (int i = 0; i < n; i++) {           // words를 빈도수 배열로 변환
            freqs[i] = strToFreq(words[i]);
        }
        
        Arrays.sort(freqs);         // 이진 탐색을 위해서 오름차순 정렬
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            answer[i] = n - binarySearch(freqs, strToFreq(queries[i]));
        }
        
        return answer;
    }
}

/*
Runtime: 9 ms, faster than 62.37% of Java online submissions for Compare Strings by Frequency of the Smallest Character.
Memory Usage: 45.2 MB, less than 70.25% of Java online submissions for Compare Strings by Frequency of the Smallest Character.
*/
