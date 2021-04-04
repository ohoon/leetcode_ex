/*
1309.
Decrypt String from Alphabet to Integer Mapping
https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
*/

class Solution {
    public String freqAlphabets(String s) {
        int length = s.length();
        int cur = 0;
        String answer = "";
        
        while (cur < length) {
            int num;
            
            if (cur + 2 < length && s.charAt(cur+2) == '#') {           // cur+2번째에 # 문자가 있으면 cur, cur+1번째의 숫자는 십의 자리 숫자로 처리
                num = Integer.parseInt(s.substring(cur, cur + 2));
                cur += 3;
            } else {                                                    // 없으면 일의 자리 숫자로 처리
                num = Integer.parseInt(s.substring(cur, cur + 1));
                cur += 1;
            }
            
            answer += (char) ('a' + num - 1);                           // ascii 코드를 이용해 복호화하여 answer에 추가
        }
        
        return answer;
    }
}

/*
Runtime: 5 ms, faster than 22.36% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
Memory Usage: 38.8 MB, less than 22.72% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
*/

/*
다른 사람의 풀이

class Solution {
    public String freqAlphabets(String str) {
        HashMap<String, Character> map = new HashMap<>();
        int k = 1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch < 'j')
                map.put(String.valueOf(k++), ch);
            else
                map.put(String.valueOf(k++)+"#", ch);
        }
        
        StringBuilder sb = new StringBuilder();
        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                sb.append(map.get(str.substring(i - 2, i+1)));
                i -= 3;
            } else {
                sb.append(map.get(str.substring(i, i + 1)));
                i--;
            }
        }
        
        return sb.reverse().toString();
    }
}

해시맵과 StringBuilder을 이용한 풀이다.
해시맵까지는 예상을 했는데, StringBuilder는 처음 봐서 놀랬다.
java에서 String 값이 자주 변동되거나 여러 String을 조합해서 한번에 출력하거나 반환할 때는 StringBuilder로 작업하는게 훨씬 효율적이라고 한다.
다음에는 Builder을 꼭 기억하고 사용하도록 하자.

*/
