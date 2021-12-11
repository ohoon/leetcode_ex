/*
1419.
Minimum Number of Frogs Croaking
https://leetcode.com/problems/minimum-number-of-frogs-croaking/
*/

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] croak = new int[5];       // c r o a k 별로 현재 진행상황을 나타내는 배열
        for (char c : croakOfFrogs.toCharArray()) {
            switch (c) {
                case 'c':
                    if (croak[4] > 0) {     // 울음소리를 낼 준비가 된 frog가 있으면 해당 frog를 사용
                        croak[4]--;
                    }
                    
                    croak[0]++;
                    break;
                case 'r':
                    if (croak[0] == 0) {    // r 차례인 frog가 없으면 -1 반환
                        return -1;
                    }
                    
                    croak[0]--;
                    croak[1]++;
                    break;
                case 'o':
                    if (croak[1] == 0) {    // o 차례인 frog가 없으면 -1 반환
                        return -1;
                    }
                    
                    croak[1]--;
                    croak[2]++;
                    break;
                case 'a':
                    if (croak[2] == 0) {    // a 차례인 frog가 없으면 -1 반환
                        return -1;
                    }
                    
                    croak[2]--;
                    croak[3]++;
                    break;
                case 'k':
                    if (croak[3] == 0) {    // k 차례인 frog가 없으면 -1 반환
                        return -1;
                    }
                    
                    croak[3]--;
                    croak[4]++;
                    break;
                default:
                    return -1;
            }
        }
        
        if (croak[0] > 0 || croak[1] > 0 || croak[2] > 0 || croak[3] > 0) {     // 아직 울음소리를 내는 중인 frog가 있으면 -1 반환
            return -1;
        }
        
        return croak[4];        // 울음소리를 모두 낸 frog의 개수 반환
    }
}

/*
Runtime: 6 ms, faster than 93.24% of Java online submissions for Minimum Number of Frogs Croaking.
Memory Usage: 39.1 MB, less than 96.34% of Java online submissions for Minimum Number of Frogs Croaking.
*/
