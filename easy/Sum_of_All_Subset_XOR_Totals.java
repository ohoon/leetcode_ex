/*
1863.
Sum of All Subset XOR Totals
https://leetcode.com/problems/sum-of-all-subset-xor-totals/
*/

class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    public int dfs(int[] arr, int index, int res) {
        if (index == arr.length) {
            return res;
        }

        return dfs(arr, index + 1, res ^ arr[index]) + dfs(arr, index + 1, res);
    }
}

/*
Runtime: 1 ms, faster than 60.25% of Java online submissions for Sum of All Subset XOR Totals.
Memory Usage: 38.1 MB, less than 43.30% of Java online submissions for Sum of All Subset XOR Totals.
*/

/*
여담

생각나는건 조합이나 비트마스킹으로 경우의수를 하나씩 구해서 XOR합을 구하는 것인데,
다른 사람의 풀이를 보니 재귀적으로 정말 멋지게 푼 코드가 있었다..
재귀적인 코드에 익숙해진줄 알았는데 아직 아닌가보다.
시간을 두고 다시 풀어보자.

 */