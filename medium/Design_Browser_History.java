/*
1472.
Design Browser History
https://leetcode.com/problems/design-browser-history/
*/

class BrowserHistory {

    private List<String> history;       // url 이동 기록이 담길 리스트
    
    private int index;                  // 현재 history 인덱스
    
    private int limit;                  // history를 참조할 수 있는 최대 인덱스
    
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        index = 0;
        limit = 0;
    }
    
    public void visit(String url) {             // visit하게 되면 그 인덱스 이후의 history를 참조 불가능하게 됨
        if (index == history.size() - 1) {
            history.add(url);
        } else {
            history.set(index + 1, url);
        }
        
        limit = ++index;
    }
    
    public String back(int steps) {
        index = Math.max(index - steps, 0);
        return history.get(index);
    }
    
    public String forward(int steps) {
        index = Math.min(index + steps, limit);
        return history.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

/*
Runtime: 108 ms, faster than 50.08% of Java online submissions for Design Browser History.
Memory Usage: 81.4 MB, less than 79.35% of Java online submissions for Design Browser History.
*/
