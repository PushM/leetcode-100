public class LinkedList_reverseKGroup {
    /*
    K 个一组翻转链表:hard前面那个是两两一组翻转、
    同样是前面加一个dummy
    维护head、tail、pre、next四个指针，head和tail指向子链表的头和尾，pre指向子链表的前一个节点，tail指向子链表的后一个节点。
    并用到之前已实现的翻转链表
    时间 n 空间 1
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode tail = head;
        while (head != null){
            //判断还够不够k个节点
            for (int i = 0; i < k-1; i++){
                tail = tail.next;
                if(tail == null){
                    return dummy.next;
                }
            }
            //记录tail的next节点
            ListNode nextNode = tail.next;
            //翻转子链表，返回head和tail
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nextNode;
            pre = tail;
            head = nextNode;
            tail = nextNode;

        }
        return dummy.next;
    }

    public ListNode[] reverseList(ListNode head, ListNode tail){

        ListNode curr = head;
        ListNode prev = tail.next;

//        while(curr != tail.next){
        while (prev != tail){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return new ListNode[]{prev, head};
    }
}
