/*
1352.
Product of the Last K Numbers
https://leetcode.com/problems/product-of-the-last-k-numbers/
*/

class ProductOfNumbers {
    private List<Integer> list;
    
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {         // num으로 0이 들어오는 경우, list를 초기화시킴
            list.clear();
            return;
        }
        
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        
        list.add(list.get(list.size() - 1) * num);      // 앞에서부터 곱을 누적시켜서 곱 연산 횟수를 최적화함
    }
    
    public int getProduct(int k) {
        if (k > list.size()) {      // k가 list 사이즈보다 높을 경우 list 중간에 0이 들어가서 초기화된 경우이므로 0을 반환
            return 0;
        }
        
        if (k == list.size()) {     // list의 전체 곱을 구하는 것이므로 마지막 요소 값을 그대로 반환해주면 됨
            return list.get(list.size() - 1);
        }
        
        return list.get(list.size() - 1) / list.get(list.size() - k - 1);       // 전체 곱 / 0~(n-k)의 곱 하면 (n-k)~n까지의 곱을 구할 수 있음
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

/*
Runtime: 20 ms, faster than 47.18% of Java online submissions for Product of the Last K Numbers.
Memory Usage: 74.5 MB, less than 17.28% of Java online submissions for Product of the Last K Numbers.
*/
