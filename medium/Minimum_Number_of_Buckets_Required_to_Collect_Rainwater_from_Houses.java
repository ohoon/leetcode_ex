/*
2086.
Minimum Number of Buckets Required to Collect Rainwater from Houses
https://leetcode.com/problems/minimum-number-of-buckets-required-to-collect-rainwater-from-houses/
*/

class Solution {
    public int minimumBuckets(String street) {      // greedy
        String s = street.replace("H.H", "  ").replace(".H", " ").replace("H.", " ");   // 하나의 bucket으로 2개의 house의 비를 받을 수 있는 자리 먼저 대체 나머지는 1:1로 대체
        if (s.contains("H")) {      // bucket으로 커버가 안되는 house가 있으면 -1 반환
            return -1;
        }
        
        return street.length() - s.length();        // H.H의 경우 2개의 공백, H. 또는 .H의 경우 1개의 공백으로 대체되기 때문에 bucket 개수만큼 원래의 길이에서 감소함
    }
}

/*
Runtime: 19 ms, faster than 26.80% of Java online submissions for Minimum Number of Buckets Required to Collect Rainwater from Houses.
Memory Usage: 54.1 MB, less than 9.22% of Java online submissions for Minimum Number of Buckets Required to Collect Rainwater from Houses.
*/
