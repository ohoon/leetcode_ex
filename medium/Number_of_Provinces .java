/*
547.
Number of Provinces
https://leetcode.com/problems/number-of-provinces/
*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int answer = 0;
        int n = isConnected.length;
        boolean[] isMarked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isMarked[i]) {
                continue;
            }

            isMarked[i] = true;
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 0 || isMarked[j]) {
                    continue;
                }

                isMarked[j] = true;
                mark(isConnected, j, isMarked);
            }

            answer++;
        }

        return answer;
    }

    private void mark(int[][] isConnected, int i, boolean[] isMarked) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 0 || isMarked[j]) {
                continue;
            }

            isMarked[j] = true;
            mark(isConnected, j, isMarked);
        }
    }
}

/*
Runtime: 1 ms, faster than 71.52% of Java online submissions for Number of Provinces.
Memory Usage: 39.6 MB, less than 84.43% of Java online submissions for Number of Provinces.
*/

/*
다른 사람의 풀이

class UnionFind{
    int[] f;
    public UnionFind(int size){
        f = new int[size];
        for(int i = 0; i < size; i++){
            f[i] = i;
        }
    }
    public int find(int x){
        if (f[x] != x){
            f[x] = find(f[x]);
        }
        return f[x];
    }
    public void unite(int x, int y){
        int fx = find(x);
        int fy = find(y);
        f[f[y]] = fx;
    }
}

class Solution {
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int row = M.length, column = M[0].length;
        UnionFind uf = new UnionFind(row);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < row; i++){
            for(int j = i + 1; j < column; j ++){
                if (M[i][j] == 1){
                    uf.unite(i,j);
                }
            }
        }
        for(int i=0; i<row; i++){
            uf.f[i] = uf.find(i);
            set.add(uf.f[i]);
        }
        return set.size();

    }
}

위의 풀이는 dfs를 이용하지 않고 각 숫자들이 어떤 그룹에 속하는지
확인하여 unite, 즉 통합한다.
모든 통합 과정이 끝나고 난 후에, 그룹의 개수를 set을 이용하여 세어서 province의 개수를 알아내는 방법이다.
UnionFind라는 클래스를 만들어서 풀이한 것이 인상깊어서 가져왔는데 굉장히 영리한 풀이라고 생각이 든다.

 */