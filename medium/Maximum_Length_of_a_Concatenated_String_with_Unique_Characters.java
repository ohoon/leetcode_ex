/*
1239.
Maximum Length of a Concatenated String with Unique Characters
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
*/

class Solution {
    private int backtrack(List<String> arr, int i, boolean[] used) {        // backtrack
        if (i == arr.size()) {
            return 0;
        }

        boolean[] temp = used.clone();      // 해당 string을 concat한 경우와 안한 경우를 나누기 위함
        for (char c : arr.get(i).toCharArray()) {
            if (temp[c-'a']) {
                return backtrack(arr, i+1, used);       // unique하지 않으면 해당 string은 concat하지 않고 그대로 다음 string으로 넘어감
            }

            temp[c-'a'] = true;     // 사용한 알파벳은 temp에 기록
        }

        return Math.max(arr.get(i).length() + backtrack(arr, i+1, temp), backtrack(arr, i+1, used));        // 해당 string을 concat한 경우와 그냥 넘어간 경우 중 최대  채택
    }

    public int maxLength(List<String> arr) {
        return backtrack(arr, 0, new boolean[26]);
    }
}
