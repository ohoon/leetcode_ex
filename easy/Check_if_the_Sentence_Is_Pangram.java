/*
1832.
Check if the Sentence Is Pangram
https://leetcode.com/problems/check-if-the-sentence-is-pangram/
*/

class Solution {
    public boolean checkIfPangram(String sentence) {
        // sentence의 각 원소를 set에 넣어서 26개 알파벳이 모두 있는지 확인
        return sentence.chars().mapToObj(c -> (char)c).collect(Collectors.toSet()).size() == 26;
    }
}

/*
Runtime: 4 ms, faster than 14.07% of Java online submissions for Check if the Sentence Is Pangram.
Memory Usage: 37.3 MB, less than 51.53% of Java online submissions for Check if the Sentence Is Pangram.
*/

/*
다른 사람의 풀이

class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] letters  = new boolean[26];

        for(char c : sentence.toCharArray()) {
            letters[c - 'a'] = true;
        }

        //find any letter that not exist
        for(boolean existLetter : letters) {
            if(!existLetter) return false;
        }

        return true;
    }
}

버킷을 만들어놓고 1-pass후에 false인 버킷이 있는지 검증하는 방법이다.
불필요하게 매핑하는 과정도 없어 더 깔끔하고 좋은 코드라고 생각한다.

 */