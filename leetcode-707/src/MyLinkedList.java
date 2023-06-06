/*
//单链表
class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        //创建一个虚拟头节点
        ListNode curr = head;
        //判断index的合法性
        if(index >=size || index < 0){
            return -1;
        }
        //进行遍历找到index的ListNode，因为存在虚拟头节点 所以应该遍历到index+1个节点
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);

    }
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        //判断index的合法性
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        //因为添加了元素，所以size需要++
        size++;
        //因为要插入，所以必须获取插入的前一个元素-->链表插入的特性
        ListNode pre = head;
        //节点的前一个元素 即需要遍历到index-1
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        //判断index的合法性
        if(index <0 || index >= size){
            return;
        }
        //删除后size--
        size--;
        //如果index == 0 删除的就是头节点 需要对头节点进行移位
        if(index == 0){
            head = head.next;
            return;
        }


        ListNode pre = head;
        //遍历获得删除元素的前一个元素
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

    }
}*/
//双指针
class MyLinkedList {
    int size;
    ListNode head,tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        //首尾相连
        head.next=tail;
        tail.prev = head;
    }

    public int get(int index) {
        if(index >=size || index < 0){
            return -1;
        }
        ListNode cur = this.head;
        if(index >=size / 2){
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur= cur.prev;
            }
        }else{
            for (int i = 0; i < index + 1; i++) {
                cur=cur.next;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);

    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        //判断index的合法性
        if(index>size){
            return;
        }if(index<0){
            index = 0;
        }
        size++;
        //找到前驱
        ListNode pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //new一个值为val的新节点
        ListNode newNode = new ListNode(val);
        //添加新节点
        newNode.next = pre.next;
        pre.next.prev = newNode;
        newNode.prev = pre;
        pre.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if(index>=size || index<0){
            return;
        }
        size--;
        //此处不用考虑0索引 如果index为0 不会进入循环
        ListNode pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next.next.prev = pre;
        pre.next=pre.next.next;

    }
}
