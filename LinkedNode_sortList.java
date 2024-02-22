public class LinkedNode_sortList {
    /*
    链表排序
    归并排序；
    自顶向下（递归）
    时间 nlogn 空间 logn
    自底向上（迭代）
    时间 nlogn 空间 1

    subLength从1开始每次加倍
    每个subLength，都在对链表遍历一遍进行merge合并。
     */
    public ListNode sortList(ListNode head) {

        ListNode dummy = new ListNode(0,head);
        ListNode curr = head ;
        //求链表的总长度
        int listLength = 0 ;
        while (curr != null){
            curr = curr.next;
            ++listLength;
        }

        //subLength进行加倍
        for (int subLength = 1; subLength < listLength; subLength <<= 1){
            //遍历链表，两两subLength长度个链表进行merge，合并前记得记录下prev和next合并后要再链接好
            ListNode prev = dummy ;
            curr = dummy.next;
            while (curr != null){
                ListNode head1 = curr;
                for(int i = 1; i<subLength && curr.next!=null ; i++){
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;//要把head1和head2断开
                curr = head2;
//                for (int i = 1; i<subLength && curr.next!=null ; i++){
//                    curr = curr.next;
//                }
                for (int i = 1; i<subLength && curr !=null && curr.next != null; i++){
                    //为什么要加一个curr !=null，因为有可能在遍历head1时就已经curr.next==null跳出循环了。
                    //这里的curr时head2也就是curr.next所以要判断一下前面是不是已经完了
                    curr = curr.next;
                }

                //记录head2链表的next
                ListNode next = null;
                if (curr != null){
                    next = curr.next;
                    curr.next = null;
                }
                //merge，返回合并后的头和尾
                ListNode[] mergeNode = mergeLinkedList(head1, head2);

                prev.next = mergeNode[0];
                mergeNode[1].next = next;

                prev = mergeNode[1];
                curr = next;

            }

        }
        return dummy.next;
    }

    public ListNode[] mergeLinkedList(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        while (temp.next != null){
            temp = temp.next;
        }
        return new ListNode[]{dummyHead.next, temp};
    }

}
