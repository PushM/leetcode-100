public class LinkedList_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        分为迭代法和递归法 时间 m+n 空间 1
        迭代法：
        使用prev记录上一个节点，list1和list2作为两个指针，还要记录一下头指针
        时间O（m+n） 空间 1

        一个技巧吧 while (list1 != null && list2 != null)就不需要判断list1和list2是否为null了，
        所以一开始新建一个节点head，最后返回head.next，而不是先让head指向list1或list2的头
         */

        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null? list2:list1;

        return head.next;
    }
}
