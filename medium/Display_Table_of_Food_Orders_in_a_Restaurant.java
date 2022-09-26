/*
1418.
Display Table of Food Orders in a Restaurant
https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
*/

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer> menuMap = new TreeMap<>();
        for (List<String> order : orders) {
            if (!menuMap.containsKey(order.get(2))) {
                menuMap.put(order.get(2), -1);
            }
        }
        
        int index = 0;
        for (String menu : menuMap.keySet()) {
            menuMap.put(menu, index++);
        }
        
        Map<Integer, int[]> orderMap = new TreeMap<>();
        int menuCount = menuMap.keySet().size();
        for (List<String> order : orders) {
            if (!orderMap.containsKey(Integer.valueOf(order.get(1)))) {
                orderMap.put(Integer.valueOf(order.get(1)), new int[menuCount]);
            }
            
            int menuIndex = menuMap.get(order.get(2));
            orderMap.get(Integer.valueOf(order.get(1)))[menuIndex]++;
        }
        
        List<List<String>> answer = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        for (String menu : menuMap.keySet()) {
            firstRow.add(menu);
        }
        
        answer.add(firstRow);
        for (int table : orderMap.keySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(table));
            for (int orderCount : orderMap.get(table)) {
                row.add(String.valueOf(orderCount));
            }
            
            answer.add(row);
        }
        
        return answer;
    }
}

/*
Runtime: 63 ms, faster than 67.71% of Java online submissions for Display Table of Food Orders in a Restaurant.
Memory Usage: 131 MB, less than 30.21% of Java online submissions for Display Table of Food Orders in a Restaurant.
*/
