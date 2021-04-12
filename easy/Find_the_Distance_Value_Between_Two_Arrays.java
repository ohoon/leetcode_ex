/*
1385.
Find the Distance Value Between Two Arrays
https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
*/

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int answer = arr1.length;
        for (int a1 : arr1) {
            for (int a2 : arr2) {
bs(a1 - a2) <= d) {       // distance가 d 이하면 answer을 감소                if (Math.abs(a1 - a2) <= d) {       // distance가 d 이하면 answer을 감소
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 69.79% of Java online submissions for Find the Distance Value Between Two Arrays.
Memory Usage: 38.3 MB, less than 84.26% of Java online submissions for Find the Distance Value Between Two Arrays.
*/

/*
다른 사람의 풀이

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int number: arr2) {
            tree.add(number);
        }
        for (int i=0; i<arr1.length; i++) {
            int leftValue = arr1[i] - d;
            int rightValue = arr1[i] + d;
            Set<Integer> set = tree.subSet(leftValue, rightValue+1);
            if (set.isEmpty())
                count += 1;
        }
        return count;
    }
}

TreeSet을 이용해서 +-d만큼의 범위를 subSet하는 방법을 사용한 풀이다.
이렇게되면 2중 for문으로 탐색하지 않아도 되기 때문에
O(NlogN)의 시간복잡도의 효율을 가질 수 있게 된다.

*/
