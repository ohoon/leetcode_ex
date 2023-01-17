/*
1481.
Least Number of Unique Integers after K Removals
https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] arr2 = new Integer[arr.length];       // Integer 타입으로 통일
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            arr2[i] = arr[i];
        }

        Arrays.sort(arr2, (x, y) -> map.get(x) == map.get(y) ? x - y : map.get(x) - map.get(y));
        Set<Integer> set = new HashSet<>();
        for (int i = k; i < arr.length; i++) {
            set.add(arr2[i]);
        }

        return set.size();
    }
}
