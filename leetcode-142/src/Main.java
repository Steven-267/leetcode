public class Main {
    public ListNode detectCycle(ListNode head) {
     ListNode fastNode = head;
     ListNode slowNode = head;

     while(fastNode != null && fastNode.next != null){
         slowNode = slowNode.next;
         fastNode = fastNode.next.next;
         if(slowNode == fastNode){
             ListNode index1 = fastNode;
             ListNode index2 = head;
             while(index1 != index2){
                 index1 = index1.next;
                 index2 = index2.next;
             }
             return index1;
         }
     }
     return null;


    }
}
