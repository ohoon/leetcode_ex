/*
1854.
Maximum Population Year
https://leetcode.com/problems/maximum-population-year/
*/

class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[100];
        int max = Integer.MIN_VALUE;
        int answer = -1;
        for (int[] log : logs) {
            for (int i = log[0] - 1950; i < log[1] - 1950; i++) {
                population[i]++;
            }
        }

        for (int i = 0; i < 100; i++) {
            if (population[i] > max) {
                max = population[i];
                answer = i;
            }
        }

        return 1950 + answer;
    }
}

/*
Runtime: 1 ms, faster than 75.37% of Java online submissions for Maximum Population Year.
Memory Usage: 36.9 MB, less than 77.77% of Java online submissions for Maximum Population Year.
*/

/*
다른 사람의 풀이

public int maximumPopulation(int[][] logs) {
    int pop[] = new int[2051], res = 0;
    for (var l : logs) {
        ++pop[l[0]];
        --pop[l[1]];
    }
    for (int i = 1950; i < 2050; ++i) {
        pop[i] += pop[i - 1];
        res = pop[i] > pop[res] ? i : res;
    }
    return res;
}

이러한 코드와 같이 시작점과 끝점을 +1, -1로 표기하고
가장 마지막에 버켓의 값을 누적시키는 것으로 얼마나 많은 사람들이 살고있는지 알 수 있게 된다.
나의 경우에는 각 log마다 시작점부터 끝점까지 for을 돌려야하는데
이렇게 버켓 누적하는 것을 이용하면 logs의 모든 시작점과 끝점만을 기록하고 나중에 1번만 for문하면 되니
시간적으로 많이 효율적이라고 생각된다.
이런식의 문제가 나오면 버켓을 이용한 풀이를 하도록 노력해야겠다.

 */
