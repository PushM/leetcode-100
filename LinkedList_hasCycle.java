/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LinkedList_hasCycle {
    /*
    判断链表中是否有环，两种方法
     （1）用哈希表，把之前遍历到的节点存到HashSet中，如果再遇到就说明有环
     时间 n 空间 n
     （2）Floyd 判圈算法，如果有环一定能追上，如果快指针到了null说明一定没有环，如果快慢指针指向的节点相同了一定有环。
     时间 n 当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 N 轮。
     空间 1
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //为什么fast要初始为head.next，因为要使用while（我们假想head前面还有一个节点，slow已经走了一步、fast走了两步，不影响后面的判断环）；
        // 如果使用do-while也可以把slow和fast都设为head

        while(fast != null && fast.next != null){
            //if (fast.val == slow.val){//不能只判断val。因为属性还包括next
            if (fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return  false;

//        while (slow != fast) {也可以把slow != fast放在while中
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;

    }
}
