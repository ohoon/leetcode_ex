/*
923.
3Sum With Multiplicity
https://leetcode.com/problems/3sum-with-multiplicity/
*/

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int answer = 0, mod = 1000000007;
        int[] count = new int[101];     // 각 숫자의 개수를 가지는 배열
        for (int num : arr) {
            count[num]++;
        }
        
        for (int i = 0; i < arr.length-2; i++) {
            int x = arr[i];
            count[x]--;     // x는 이후에 사용되지 않으므로 영구적으로 빈도수 감소
            int[] temp = count.clone();     // y는 현재 x에 한해서만 사용되지 않으므로 해당 x가 제거된 count의 복제본을 들고 작업
            for (int j = i+1; j < arr.length-1; j++) {
                int y = arr[j];
                temp[y]--;
                int z = target - x - y;
                if (z < 0 || z > 100) {
                    continue;
                }
                
                answer += temp[z];          // z가 있으면 z의 개수만큼 answer을 더해줌
                answer %= mod;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 277 ms, faster than 19.26% of Java online submissions for 3Sum With Multiplicity.
Memory Usage: 53.8 MB, less than 15.16% of Java online submissions for 3Sum With Multiplicity.
*/
