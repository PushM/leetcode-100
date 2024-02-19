/*
//Definition for singly-linked list.
public class ListNode {
     int val;
    ListNode next;
    ListNode(int x) {
         val = x;
         next = null;
    }
}
 */
import java.util.Set;
import java.util.HashSet;
public class LinkedList_GetIntersectionNode {
    /*
    判断相交链表
    两种方法：（1）哈希表：遍历A链表的所有值做成hash表，之后遍历B链表的所有值如果在hash表中这个node就是相交的节点（因为俩链表相交最后的节点肯定相交）、
    时间O（m+n） 空间O（m）
    （2）双指针：说是叫双指针，其实和双指针关系感觉也不大，只要是这个技巧比较巧妙。一个指针从headA开始遍历，一个指针从headB同时开始遍历，
    如果同时遍历到相同的node，则该节点为相交节点；如果同时遍历到null，则两个链表不相交。如果一个遍历到null了一个还没遍历完，就从另一个链表的头继续遍历
    时间O（m+n） 空间O（1）
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode tmp = headA;
        //hash表
        while (tmp != null){
            //hash表增加元素、
            visited.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null){
            if(visited.contains(tmp)){
                return tmp;
            }
            tmp = tmp.next;
        }
        return  null;


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null? headB:pA.next; //三元条件运算符 condition ? expression1 : expression2
            pB = pB == null? headA:pB.next;
        }
        return  pA;
    }
}
