/*
729.
My Calendar I
https://leetcode.com/problems/my-calendar-i/
*/

class MyCalendar {
    private TreeMap<Integer, Integer> map;      // floorKey ceilingKey 메서드를 사용하기 위해 Treemap 사용

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if ((prev != null && start < map.get(prev)) || (next != null && end > next)) {
            return false;
        }

        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
