/*
670.
Maximum Swap
https://leetcode.com/problems/maximum-swap/
*/

class Solution {
    private int getMaxIndex(String numStr, int cur) {           // 최대값의 인덱스를 반환하는 함수
        int res = cur;
        for (int i = cur+1; i < numStr.length(); i++) {
            if (numStr.charAt(i) >= numStr.charAt(res)) {
                res = i;
            }
        }

        return res;
    }

    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);        // string으로 변환
        for (int i = 0; i < numStr.length()-1; i++) {
            int maxIdx = getMaxIndex(numStr, i);
            if (numStr.charAt(i) == numStr.charAt(maxIdx)) {        // i번째 요소가 최대값인 경우 다음 요소로 이동
                continue;
            }

            return Integer.parseInt(numStr.substring(0, i) +        // 현재 요소와 최대값인 요소를 교환해서 정수로 변환 후 반환
                            numStr.charAt(maxIdx) +
                            numStr.substring(i+1, maxIdx) +
                            numStr.charAt(i) +
                            numStr.substring(maxIdx+1, numStr.length()));
        }

        return num;
    }
}

/*
Runtime: 13 ms, faster than 5.34% of Java online submissions for Maximum Swap.
Memory Usage: 36.6 MB, less than 30.73% of Java online submissions for Maximum Swap.
*/
