/*
2062.
Count Vowel Substrings of a String
https://leetcode.com/problems/count-vowel-substrings-of-a-string/
*/

class Solution {
    private boolean isAllTrue(boolean[] arr) {      // boolean 배열인 arr의 요소들이 모두 true인지 확인하는 함수
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public int countVowelSubstrings(String word) {
        int answer = 0;
        Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < word.length(); i++) {
            boolean[] vw = new boolean[5];
            for (int j = i; j < word.length(); j++) {
                int foundIndex = Arrays.asList(vowels).indexOf(word.charAt(j));     // 해당 문자가 모음인지 확인하기 위함
                if (foundIndex == -1) {         // 자음이면 break
                    break;
                }

                vw[foundIndex] = true;          // 모음이면 현재 vw에 갱신
                if (isAllTrue(vw)) {            // 모든 모음이 나온 상태면 answer 증가
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 10 ms, faster than 83.33% of Java online submissions for Count Vowel Substrings of a String.
Memory Usage: 39.4 MB, less than 83.33% of Java online submissions for Count Vowel Substrings of a String.
*/
