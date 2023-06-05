public class Main {
/**
 * 不添加虚拟节点方式
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */
    public ListNode removeElements1(ListNode head, int val) {
        //首先要判断并且定义头节点的值，判断是不是为是不是为val 并且头节点不能为空 如果头节点为空的话就直接返回null
        //找到一个不为空且值不等于val的节点做头节点
        while(head != null && head.val == val){
            head = head.next;
        }


        //（已经遍历过头节点前的值）如果头节点为null则直接返回head就可以-->其中没有符合val的值
        if(head == null){
            return head;
        }
        //如果成功走到这一步说明确定 head.val != val且 head ！= null -->可以开始遍历链表
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;//去除元素
            }else{
                pre = cur;//判断下一组
            }
            cur = cur.next;//判断下一组

        }
            return head;
    }


    /**
     * 添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        //第一步和方法一不一样 不需要判断head是否等于val
        if(head == null){
            return head;
        }
        //定义一个虚拟头节点
        ListNode dummy = new ListNode(-1,head);
        //主体遍历代码和方式一差不多
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
//        返回真正的头节点
        return dummy.next;
    }

    //添加虚拟头节点并且省去pre
    public ListNode removeElements3(ListNode head, int val) {
        //第一步和方法一不一样 不需要判断head是否等于val
        if(head == null){
            return head;
        }
        //定义一个虚拟头节点
        ListNode dummy = new ListNode(-1,head);
        //主体遍历代码和方式一差不多
        ListNode cur = dummy;
        while(cur != null){
            if(cur.val == val){
                cur.next = cur.next.next;
            }else {
                cur.next = cur;
            }
            cur = cur.next;
        }
//        返回真正的头节点
        return dummy.next;
    }
}
