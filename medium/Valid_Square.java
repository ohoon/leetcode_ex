/*
593.
Valid Square
https://leetcode.com/problems/valid-square/
*/

class Solution {
    private double getDistance(int[] p1, int[] p2) {        // 두 점 사이의 거리를 계산하는 메서드
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Double> set = new HashSet<>();      // 각 점 사이 간의 거리값들을 set에 삽입
        set.add(getDistance(p1, p2));
        set.add(getDistance(p1, p3));
        set.add(getDistance(p1, p4));
        set.add(getDistance(p2, p3));
        set.add(getDistance(p2, p4));
        set.add(getDistance(p3, p4));
        return !set.contains(0.0) && set.size() == 2;       // 정사각형이 되기 위해서는 동일한 점이 있으면 안되고, set 내에 각 변의 길이와 대각선의 길이 총 2개의 길이가 존재해야함
    }
}

/*
Runtime: 2 ms, faster than 42.02% of Java online submissions for Valid Square.
Memory Usage: 38.9 MB, less than 28.16% of Java online submissions for Valid Square.
*/
