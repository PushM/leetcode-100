public class LinkedList_ReverseList {
    /*
    反转链表
    迭代法：就是遍历，当前节点curr的next设为前一个节点prev，prev再换成当前节点。在这之前还得记录之前的next，再把next赋值给curr
    时间 n 空间 1
     */
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
}
