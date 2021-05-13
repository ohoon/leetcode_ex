/*
1700.
Number of Students Unable to Eat Lunch
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
*/

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int answer = students.length;
        int std = 0;
        int snd = 0;
        int prev = 0;
        do {
            if (students[std % students.length] == sandwiches[snd]) {
                students[std % students.length] = -1;
                prev = std % students.length;
                answer--;
                snd++;
            }

            std++;
        } while (snd < sandwiches.length && std % students.length != prev);

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Students Unable to Eat Lunch.
Memory Usage: 36.7 MB, less than 55.24% of Java online submissions for Number of Students Unable to Eat Lunch.
*/

/*
다른 사람의 풀이

public int countStudents(int[] students, int[] sandwiches) {
    int[] a = {0, 0};
    for (int i=0;i<students.length;i++)
        a[students[i]]+=1;
    int k = 0;
    while (k < sandwiches.length){
        if (a[sandwiches[k]] > 0)
            a[sandwiches[k]]-=1;
        else
            break;
        k+=1;}
    return sandwiches.length-k;
}

어차피 student는 계속해서 순환하기 때문에
굳이 문제 흐름대로 코딩하지 않고도 students가 원하는 모양 개수만 알면 쉽게 풀이할 수 있는 문제였다.
students에서 O형 선호가 4명, ㅁ형 선호가 3명이고 sandwiches에 O형이 3개 ㅁ형이 3개라면
O형을 선호하는 한 사람이 샌드위치를 못 받으므로 답은 1이 될 것이다.

 */