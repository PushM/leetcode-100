public class LinkedList_addTwoNumbers {
    /*
    两个链表相加，链表表示“逆序”的整数
    相加后的是一个新的链表 用head和tail记录

    时间 max（m，n） 空间 1 返回值不计入空间复杂度

     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail=null;
        int carry = 0;

        while (l1 != null || l2 != null){
            //判断l1、l2是不是null，是null的话就设为0
            int n1 = l1 !=null? l1.val:0;
            int n2 = l2 !=null? l2.val:0;
            //计算
            int sum = n1 + n2 + carry;
            //如果head为空，就新建节点head=tail=加和\
            //如果head不为空，就新建节点tail=加和
            if (head == null){
                head = tail =new ListNode(sum % 10, head);

            }else {
                tail.next = new ListNode(sum % 10, head);
                tail = tail.next;
            }
            //进位carry计算
            carry = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry == 1){
            tail.next = new ListNode(1, head);
        }
        //如果最后carry是1，要新建一个节点
        return head;
    }
}
