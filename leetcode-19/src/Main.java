public class Main {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummyhead = new ListNode(-1);
    dummyhead.next = head;
    ListNode fastNode = dummyhead;
    ListNode slowNode = dummyhead;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        while(fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;
        return dummyhead.next;

    }
}
