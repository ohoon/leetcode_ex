/*
1640.
Check Array Formation Through Concatenation
https://leetcode.com/problems/check-array-formation-through-concatenation/
*/

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        List<Integer> toList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (int[] p : pieces) {
            int cur = toList.indexOf(p[0]);
            if (cur < 0) {
                return false;
            }
            
            for (int i = 0; i < p.length; i++, cur++) {
                if (cur >= arr.length || arr[cur] != p[i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

/*
Runtime: 2 ms, faster than 21.66% of Java online submissions for Check Array Formation Through Concatenation.
Memory Usage: 38 MB, less than 81.31% of Java online submissions for Check Array Formation Through Concatenation.
*/

/*
다른 사람의 풀이

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap();
        
        for(int[] list:pieces){
            hm.put(list[0],new ArrayList());
            for(int i=1;i<list.length;i++)
                hm.get(list[0]).add(list[i]);
        }
        int index = 0;
        while(index<arr.length){
            if(!hm.containsKey(arr[index]))
                return false;
            
            ArrayList<Integer> list = hm.get(arr[index++]);
            for(int val:list){
                if(index>=arr.length || val!=arr[index])
                    return false;
                index++;
            }
        }
        return true;
    }
}

해시맵을 이용한 풀이다.
해시맵을 이용하면 여러번 indexOf 함수를 쓰지 않아도 되므로 시간 복잡도가 많이 내려갈 것으로 예상된다.

*/
