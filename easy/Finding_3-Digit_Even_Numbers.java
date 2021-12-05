/*
2094.
Finding 3-Digit Even Numbers
https://leetcode.com/problems/finding-3-digit-even-numbers/
*/

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> answer = new ArrayList<>();
        int[] arr = new int[10];        // digit별 개수를 저장하는 배열
        for (int d : digits) {
            arr[d]++;
        }

        for (int i = 100; i < 1000; i += 2) {       // 100~999의 짝수 탐색
            int x = i / 100;            // 백의 자리
            int y = (i % 100) / 10;     // 십의 자리
            int z = i % 10;             // 일의 자리
            arr[x]--;
            arr[y]--;
            arr[z]--;
            if (arr[x] >= 0 && arr[y] >= 0 && arr[z] >= 0) {        // digits으로 만들 수 있는 숫자면 answer 리스트에 추가
                answer.add(i);
            }

            arr[x]++;
            arr[y]++;
            arr[z]++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}

/*
Runtime: 6 ms, faster than 50.00% of Java online submissions for Finding 3-Digit Even Numbers.
Memory Usage: 39 MB, less than 75.00% of Java online submissions for Finding 3-Digit Even Numbers.
*/
