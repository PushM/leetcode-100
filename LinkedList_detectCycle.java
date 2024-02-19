public class LinkedList_detectCycle {
    public ListNode detectCycle(ListNode head) {
        /*
        检测链表中环的入环点
          其实就一个公式：a=c+(n−1)(b+c) 从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
          a=c “当slow和fast相遇时 slow继续走，ptr从head开始走，当slow==ptr时就是入环节点”
          （注意公式推导时slow、fast都是从head开始的，所以不能设fast为head.next了，可以使用do-while）
          因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；
          随后，它和 slow每次向后移动一个位置。最终，它们会在入环点相遇。
         */


        if(head ==null || head.next ==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        do{
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        while (fast != null && fast.next != null);

        return  null;

    }
}
