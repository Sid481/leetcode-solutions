class ListNode {
    String value;
    ListNode prev;
    ListNode next;

    public ListNode(String value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
class BrowserHistory {
    ListNode current;
    ListNode head;
    public BrowserHistory(String homepage) {
        current = new ListNode(homepage);
        head = current;
    }
    
    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        current.next = null;
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
   
    }
    
    public String back(int steps) {
        while(steps>0 && current!=head) {
            current = current.prev;
            steps--;
        }
        return current.value;
    }
    
    public String forward(int steps) {
        while(steps>0 && current.next!=null) {
            current = current.next;
            steps--;
        }
        return current.value;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */