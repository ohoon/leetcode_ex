/*
116.
Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {            // 너비우선 탐색
        if (root == null) {
            return null;
        }
        
        Deque<Node> deq = new LinkedList<>();       // queue 기능으로 사용
        deq.addLast(root);
        while (!deq.isEmpty()) {
            Deque<Node> next = new LinkedList<>();
            while (!deq.isEmpty()) {
                Node node = deq.removeFirst();
                if (!deq.isEmpty()) {               // 자신의 오른쪽에 있는 노드를 next 지정
                    node.next = deq.peekFirst();
                }
                
                if (node.left == null || node.right == null) {
                    continue;
                }
                
                next.addLast(node.left);
                next.addLast(node.right);
            }
            
            deq.addAll(next);
        }
        
        return root;
    }
}

/*
Runtime: 8 ms, faster than 5.33% of Java online submissions for Populating Next Right Pointers in Each Node.
Memory Usage: 48.1 MB, less than 13.45% of Java online submissions for Populating Next Right Pointers in Each Node.
*/
