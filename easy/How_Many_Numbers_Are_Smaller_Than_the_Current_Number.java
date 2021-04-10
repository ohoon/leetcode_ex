/*
1365.
How Many Numbers Are Smaller Than the Current Number
https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] sorted = nums.clone();            // sorting용 nums의 카피본
        Arrays.sort(sorted);
        
        for (int i = 0; i < sorted.length; i++) {
            map.putIfAbsent(sorted[i], i);      // hashmap에 sorting된 인덱스 값을 등록, 이미 key가 존재하면 무시하고 다음 요소로
        }
        
        return Arrays.stream(nums).map(map::get).toArray();     // nums의 요소를 hashmap에 등록된 값으로 변환해서 반환
    }
}

/*
Runtime: 6 ms, faster than 59.55% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
Memory Usage: 39.2 MB, less than 32.06% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
*/

/*
다른 사람의 풀이

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        var buck = new int[101];
        
        for (int i = 0; i < nums.length; i++)
            buck[nums[i]]++;                                // count each occurence
      
        for (int i = 1; i < buck.length; i++)
            buck[i] += buck[i - 1];                         // calc how manu numbers are smaller

        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] == 0 ? 0 : buck[nums[i] - 1]; // fill resulting array
        
        return nums;
    }
}

버켓이란 배열을 만들어 nums의 요소를 인덱스로 한 위치에 값을 넣고 앞에서부터 값을 누적시켜서
인덱스가 커지면 커질수록 값이 증가하도록 버켓을 세팅한다.
그리고 nums를 순환하며 버켓을 참조하며 값을 대입시켜 문제를 풀이하는 코드다.
이처럼 풀면 시간복잡도는 O(N)으로 merge sort인 O(NlogN)보다 효율적이라고 볼 수 있다.

*/
