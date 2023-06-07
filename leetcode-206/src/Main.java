

public class Main {
    //双指针
    /*public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        ListNode cur = head;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }*/
    //递归
    public ListNode reverseList(ListNode head) {
        return reverse(null,head);
    }
    private ListNode reverse(ListNode pre,ListNode cur) {
        if(cur == null){
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur,temp);
    }
}
