/*
2383.
Minimum Hours of Training to Win a Competition
https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/
*/

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int needEnergy = Arrays.stream(energy).sum();
        int answer = Math.max(needEnergy - initialEnergy + 1, 0);
        int exp = initialExperience;
        for (int i = 0; i < experience.length; i++) {
            if (exp <= experience[i]) {
                answer += experience[i] - exp + 1;
                exp = experience[i] + 1;
            }
            
            exp += experience[i];
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 28.57% of Java online submissions for Minimum Hours of Training to Win a Competition.
Memory Usage: 41.9 MB, less than 57.14% of Java online submissions for Minimum Hours of Training to Win a Competition.
*/
