/*
2491.
Divide Players Into Teams of Equal Skill
https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/
*/

class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int sum = Arrays.stream(skill).sum();
        if (n > 2 && sum % (n/2) != 0) {        // divide될 수 없는 조건이면 -1 반환
            return -1;
        }

        long answer = 0, each = sum / (n/2);    // each = 동등하게 divide되기 위한 skill 값
        Arrays.sort(skill);
        for (int i = 0; i < n/2; i++) {
            if (skill[i] + skill[n-i-1] != each) {      // 가장 작은 것과 가장 큰 것을 하나의 팀으로 구성
                return -1;
            }

            answer += skill[i] * skill[n-i-1];
        }

        return answer;
    }
}
