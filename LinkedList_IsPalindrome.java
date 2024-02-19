import java.util.ArrayList;
import java.util.List;

public class LinkedList_IsPalindrome {
    /*
    判断链表是不是回文
    （1）把链表变为数组，然后判断
    （2）把用递归遍历链表，并维护一个全局变量head 然后返回时和head比较
    （3）把后半部分做“反转链表”，然后判断回文
            1、找到前半部分链表的尾节点。（使用快慢指针判断）
            2、反转后半部分链表。
            3、判断是否回文。
            4、恢复链表。
            5、返回结果。
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();
        ListNode curr = head;
        while(curr != null){
            vals.add(curr.val);
            curr = curr.next;
        }
        int front = 0;
        int back = vals.size()-1;
        while(front < back){
            if(!vals.get(front).equals(vals.get(back)) ){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
//        1、找到前半部分链表的尾节点。（使用快慢指针判断）如果节点总数为奇数，返回值为中间那个节点；如果节点总数为偶数，返回值为第n/2-1的节点
        ListNode firstHarfEnd = findEndOfFirstHalf(head);
//        2、反转后半部分链表。
        ListNode secondHalfStart = reverseList(firstHarfEnd.next);
//        3、判断是否回文。
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean ans = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                ans = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
//        4、恢复链表。?
        firstHarfEnd.next = reverseList(secondHalfStart);
//        5、返回结果。
        return ans;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode findEndOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
