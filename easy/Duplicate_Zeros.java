/*
1089.
Duplicate Zeros
https://leetcode.com/problems/duplicate-zeros/
*/

class Solution {
    public void duplicateZeros(int[] arr) {
        int idx = arr.length - 1;               // source index
        int cur = idx;                          // reference cursor
        for (int i = 0; i <= cur; i++) {
            if (arr[i] == 0) {                  // 0을 만나면
                if (i == cur){                  // 복사할 자리가 없으면 source 끝에 0을 덮어씌우고 idx를 감소
                    arr[idx--] = 0;
                }
                
                cur--;
            }
        }
        
        while (idx >= 0) {
            if (arr[cur] == 0) {                // 0을 가리키면
                arr[idx--] = 0;                 // 0을 덮어씌우고 idx 감소
            }
            
            if (idx >= 0) {                     // 인덱싱 에러 방지
                arr[idx--] = arr[cur--];        // idx자리에 cur가 가리키는 수를 덮어씌움
            }
        }
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Duplicate Zeros.
Memory Usage: 38.8 MB, less than 93.21% of Java online submissions for Duplicate Zeros.
*/

/*
여담

간단한 문제일거라 생각했는데, 0이 복사될 수 있는지 없는지 확인하는 작업이 생각보다 어려웠다.
코드도 지저분해져서 마음에는 안들지만 java라서 그런가 속도는 꽤 잘 나온다고 생각이 듬

*/
