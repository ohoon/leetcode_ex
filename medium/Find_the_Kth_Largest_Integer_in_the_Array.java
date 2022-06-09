/*
1985.
Find the Kth Largest Integer in the Array
https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
*/

class Solution {
    private int compareTo(String n1, String n2) {
        if (n1.length() != n2.length()) {       // 문자열 길이로 1차 비교
            return n1.length() - n2.length();
        }
        
        for (int i = 0; i < n1.length(); i++) {     // 가장 높은 자리부터 시작하여 서로 다른 digit이 발견되면 비교하고 결과 반환
            if (n1.charAt(i) != n2.charAt(i)) {
                return n1.charAt(i) - n2.charAt(i);
            }
        }
        
        return 0;
    }
    
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (x, y) -> compareTo(y, x));       // 위의 comparator로 정렬
        return nums[k-1];
    }
}

/*
Runtime: 30 ms, faster than 82.53% of Java online submissions for Find the Kth Largest Integer in the Array.
Memory Usage: 48.3 MB, less than 96.87% of Java online submissions for Find the Kth Largest Integer in the Array.
*/
