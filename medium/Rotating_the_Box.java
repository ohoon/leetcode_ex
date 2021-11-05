/*
1861.
Rotating the Box
https://leetcode.com/problems/rotating-the-box/
*/

class Solution {
    private char[][] rotate(char[][] box) {             // box를 90도 회전한 배열을 반환하는 함수
        int height = box.length;
        int width = box[0].length;
        char[][] rotated = new char[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rotated[j][height-i-1] = box[i][j];
            }
        }
        
        return rotated;
    }
    
    private void fall(char[][] box) {                   // box에 중력을 적용시키는 함수
        int height = box.length;
        int width = box[0].length;
        for (int i = height-1; i >= 0; i--) {
            for (int j = 0; j < width; j++) {
                if (box[i][j] != '.') {
                    continue;
                }
                
                for (int l = i-1; l >= 0; l--) {
                    if (box[l][j] == '*') {
                        break;
                    }
                    
                    if (box[l][j] == '#') {
                        box[i][j] = '#';
                        box[l][j] = '.';
                        break;
                    }
                }
            }
        }
    }
    
    public char[][] rotateTheBox(char[][] box) {
        char[][] rotated = rotate(box);
        fall(rotated);
        return rotated;
    }
}

/*
Runtime: 37 ms, faster than 9.24% of Java online submissions for Rotating the Box.
Memory Usage: 75.4 MB, less than 70.15% of Java online submissions for Rotating the Box.
*/

/*
다른 사람의 풀이

public char[][] rotateTheBox(char[][] box) {
    int m = box.length, n = box[0].length;
    char [][] res = new char[n][m];
    for (int i = 0; i < m; ++i)
        for (int j = n - 1, k = n - 1; j >= 0; --j) {
            res[j][m - i - 1] = '.';
            if (box[i][j] != '.') {
                k = box[i][j] == '*' ? j : k;
                res[k--][m - i - 1] = box[i][j];
            }
        }
    return res;
}

내 풀이의 경우에는 rotate 단계와 중력 적용 단계를 나누어서 실행했다.
하지만 다른 사람의 풀이에서는 투 포인터 기법을 통해서 회전하는 단계에서 중력을 고려한 위치에 돌을 두는 방법으로 최적화를 시켰다.
회전과 중력 모두 고려하는 방법이다보니 이해하는데도 꽤 시간이 걸렸다. 이런 방법을 생각해낸 것이 대단하다고 생각한다.

*/
