/*
1295.
Find Numbers with Even Number of Digits
https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
*/

class Solution {
    public int findNumbers(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            int length = Integer.toString(num).length();
            if (length % 2 == 0) {
                answer++;
            }
        }

        return answer;
    }
}

/*
Runtime: 1 ms, faster than 94.04% of Java online submissions for Find Numbers with Even Number of Digits.
Memory Usage: 38.7 MB, less than 35.24% of Java online submissions for Find Numbers with Even Number of Digits.
*/

/*
다른 사람의 풀이

public int findNumbers(int[] nums) {
     return (int) Arrays.stream(nums)
                        .map(e -> String.valueOf(e).length())
                        .filter(e -> e % 2 == 0)
                        .count();
}

stream을 이용한 한줄 풀이.
속도면에서는 아마 stream 쪽이 two pass에 가깝기 때문에 one pass인 내 풀이가 더 빠르지 않을까 싶다.

 */