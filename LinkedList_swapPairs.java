public class LinkedList_swapPairs {
    /*
    两两交换链表中的节点
    递归法？ 时间 n 空间 n
        判断 非null
        ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;

    迭代法： 时间 n 空间 1
        加一个dummy node
        ListNode node1 = temp.next;
        ListNode node2 = temp.next.next;
        tmp.next = node2
        node1.next = node2.next
        node2.next = node1
        tmp = node1
        如果tmp.next
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode tmp = dummy;
        while(tmp.next != null && tmp.next.next != null){
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return  dummy.next;

    }
}
