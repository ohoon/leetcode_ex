/*
1442.
Count Triplets That Can Form Two Arrays of Equal XOR
https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
*/

class Solution {
    public int countTriplets(int[] arr) {
        int answer = 0;
        for (int i = 1; i < arr.length; i++) {      // 앞에서부터 xor로 누적시킨 값으로 재정의
            arr[i] ^= arr[i-1];
        }
        
        for (int i = 0; i < arr.length-1; i++) {    // arr[i]를 기준으로 좌 우측의 xor 값을 이용해서 a, b값을 구해서 같은지 비교
            for (int j = i; j >= 0; j--) {      // arr[i]와 arr[j]를 xor 연산시키면 j부터 i까지의 xor 값인 a를 구할 수 있음
                int a = (i != j ? arr[i] ^ arr[j] : arr[i]);
                for (int k = i+1; k < arr.length; k++) {    // arr[i]와 arr[k]를 xor 연산시키면 i부터 k까지의 xor 값인 b를 구할 수 있음
                    int b = arr[i] ^ arr[k];
                    if (a == b) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 52 ms, faster than 5.82% of Java online submissions for Count Triplets That Can Form Two Arrays of Equal XOR.
Memory Usage: 38.5 MB, less than 25.40% of Java online submissions for Count Triplets That Can Form Two Arrays of Equal XOR.
*/
