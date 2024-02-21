public class LinkedList_removeNthFromEnd {
    /*
    删除链表的倒数第 N 个结点
    (1)先求长度：先求出链表的长度n，之后再遍历到第n-N+1节点，删除后面的节点
    时间 n 空间 1
    （2）栈：遍历时一个个入栈，遍历完之后找到栈顶的第N个元素
    时间 n 空间 n
    （3）快慢指针：一个快指针，一个慢指针，他们间隔n-1个节点，当快指针遍历到null，满指针也就到了第n个节点
    时间 n 空间 1
    用到dummy node哑节点，因为有可能倒数第n个正好是第1个，为了解题连贯。

     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = dummy;
        int length = getLinkedListLength(dummy);
        for (int i = 0;i<length -n-1 ;i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }

    public int getLinkedListLength(ListNode p){
        int length = 0;
        while (p !=null ){
            ++length;
            p = p.next;
        }
        return length;
    }
}
