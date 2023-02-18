/*
881.
Boats to Save People
https://leetcode.com/problems/boats-to-save-people/
*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {    // greedy
        int answer = 0;
        int L = 0, R = people.length - 1;
        Arrays.sort(people);
        while (L <= R) {                                // 가장 무거운 사람부터 태움
            if (people[L] + people[R] <= limit) {       // 가장 가벼운 사람도 가능하면 태워감
                L++;
            }

            R--;
            answer++;
        }

        return answer;
    }
}
