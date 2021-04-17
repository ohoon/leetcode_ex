/*
1413.
Kids With the Greatest Number of Candies
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/submissions/
*/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answer = new ArrayList<>();
        int max = Collections.max(Arrays.stream(candies).boxed().collect(Collectors.toList()));         // array를 list로 바꿔서 최댓값 찾기
        int need = max - extraCandies;              // 조건이 성립하는 사탕 최소 갯수
        for (int candy : candies) {
            answer.add(candy >= need);
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 5.03% of Java online submissions for Kids With the Greatest Number of Candies.
Memory Usage: 38.9 MB, less than 59.90% of Java online submissions for Kids With the Greatest Number of Candies.
*/
